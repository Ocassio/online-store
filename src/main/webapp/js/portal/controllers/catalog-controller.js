portalControllers.controller("CatalogController", function($rootScope, $http, shoppingCart, $scope, $state, catalog) {

    var catalogCtrl = this;

    $scope.totalItems = 0;
    $scope.itemsPerPage = 6;
    $scope.maxSize = 5;
    this.maxRating = 5;

    $scope.currentPage = 1;

    this.offersInitialized = false;
    this.categoriesInitialized = false;

    this.offers = [];

    catalog.getOffers().success(function(data) {
        catalogCtrl.offers = data;
        catalogCtrl.totalItems = data.length;

        catalogCtrl.offersLoadingCallback();
    });

    this.categories = [];

    catalog.getCategories().success(function(data) {
        catalogCtrl.categories = data;

        catalogCtrl.categoriesLoadedCallback();
    });

    this.offersLoadingCallback = function() {
        this.offersInitialized = true;
        if ($state.params.page) {
            $scope.currentPage = $state.params.page;
        }
    };

    this.categoriesLoadedCallback = function() {
        this.categoriesInitialized = true;
        if ($state.params.category) {
            this.currentCategory = _.find(this.categories, function(category) {
                return category.id === $state.params.category;
            });
        }
    };

    $scope.setPageUrl = function() {
        if (catalogCtrl.offersInitialized && catalogCtrl.categoriesInitialized) {
            var categoryId;
            if (catalogCtrl.currentCategory) {
                categoryId = catalogCtrl.currentCategory.id;
            }
            var params = {
                page: $scope.currentPage,
                category: categoryId
            };
            $state.transitionTo('catalog', params, $rootScope.consts.routing.TRANSITION_WITHOUT_RELOADING_OPTIONS);
        }
    };

    this.getCurrentCategoryIdForFilter = function() {
        if (this.currentCategory) {
            return this.currentCategory.id;
        }

        return "!null";
    };

    this.addToCart = function(offer) {
        this.disableOfferButton(offer);
        shoppingCart.add(offer).success(this.enableOfferButton.bind(this, offer));
    };

    this.removeFromCart = function(offer) {
        this.disableOfferButton(offer);
        shoppingCart.remove(offer).success(this.enableOfferButton.bind(this, offer));
    };

    this.enableOfferButton = function(offer) {
        offer.readOnly = false;
    };

    this.disableOfferButton = function(offer) {
        offer.readOnly = true;
    };

});