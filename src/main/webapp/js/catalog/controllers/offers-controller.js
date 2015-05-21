catalogControllers.controller("OffersController", function($rootScope, $scope, $http, $state, $modal, user, catalog) {

    if (!user.isSignedIn()) {
        $state.go("login");
    }

    var offersCtrl = this;

    $scope.totalItems = 0;
    $scope.itemsPerPage = 10;
    $scope.maxSize = 5;

    $scope.currentPage = 1;

    this.offersInitialized = false;

    this.selectedOffer = null;

    this.offers = [];

    catalog.getOffers().success(function(data) {
        this.offers = data;
        this.offersLoadingCallback();
    }.bind(this));

    this.offersLoadingCallback = function() {
        this.offersInitialized = true;
        if ($state.params.page) {
            $scope.currentPage = $state.params.page;
        }
    };

    this.add = function(offer) {
        var dialog = $modal.open({
            templateUrl: "views/catalog/catalog-offers-add.html",
            controller: "OffersAddController as offersAddCtrl"
        });

        dialog.result.then(this.onAdd.bind(this));
    };

    this.edit = function(offer) {

    };

    this.delete = function() {
        if (this.selectedOffer) {
            var dialog = $modal.open({
                templateUrl: "views/catalog/catalog-offers-delete-confirm.html",
                controller: "OffersDeleteConfirmController"
            });

            dialog.result.then(this.processDelete.bind(this));
        }
    };

    this.processEdit = function(offer) {
        if (this.selectedOffer) {
            catalog.editOffer(offer).success(this.onEdit.bind(this, offer));
        }
    };

    this.processDelete = function() {
        catalog.deleteOffer(this.selectedOffer.id).success(this.onDelete.bind(this));
    };

    this.onAdd = function(offer) {
        this.offers.push(offer);
    };

    this.onEdit = function(offer) {
        _.find(this.offers, function(current, index, offers) {
            if (current.id === offer.id) {
                offers[index] = offer;
                this.selectedOffer = offer;

                return true;
            }

            return false;
        }.bind(this));
    };

    this.onDelete = function() {
        this.offers = _.filter(this.offers, function(offer) {
            return offer.id !== this.selectedOffer.id;
        }.bind(this));
        this.selectedOffer = null;
    };

    $scope.$on($rootScope.consts.events.ADD, this.add.bind(this));
    $scope.$on($rootScope.consts.events.EDIT, this.edit.bind(this));
    $scope.$on($rootScope.consts.events.DELETE, this.delete.bind(this));

    this.isSelected = function(offer) {
        return offer === this.selectedOffer;
    };

    this.select = function(offer) {
        if (!this.isSelected(offer)) {
            this.selectedOffer = offer;
        } else {
            this.selectedOffer = null;
        }
    };

    $scope.setPageUrl = function() {
        if (offersCtrl.offersInitialized) {
            var params = {
                page: $scope.currentPage
            };
            $state.transitionTo('offers', params, $rootScope.consts.routing.TRANSITION_WITHOUT_RELOADING_OPTIONS);
        }
    };

});