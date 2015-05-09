catalogControllers.controller("OffersController", function($rootScope, $scope, $http, $state, user) {

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

    $http.get("/online-store/rest/offers/get").success(function(data) {
        this.offers = data;
        this.offersLoadingCallback();
    }.bind(this));

    this.offersLoadingCallback = function() {
        this.offersInitialized = true;
        if ($state.params.page) {
            $scope.currentPage = $state.params.page;
        }
    };

    this.onAdd = function() {

    };

    this.onEdit = function() {

    };

    this.onDelete = function() {

    };

    $scope.$on($rootScope.consts.events.ADD, this.onAdd.bind(this));
    $scope.$on($rootScope.consts.events.EDIT, this.onEdit.bind(this));
    $scope.$on($rootScope.consts.events.DELETE, this.onDelete.bind(this));

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