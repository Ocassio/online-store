portalControllers.controller("CatalogController", function($rootScope, $http, shoppingCart, $scope, $state) {

    var catalog = this;

    this.totalItems = 0;
    this.itemsPerPage = 6;
    this.maxSize = 5;
    this.maxRating = 5;

    this.currentPage = 1;

    this.offersInitialized = false;
    this.categoriesInitialized = false;

    this.offers = [];

    $http.get("/online-store/rest/offers/get").success(function(data) {
        catalog.offers = data;
        catalog.totalItems = data.length;

        catalog.offersLoadingCallback();
    });

    this.categories = [];

    $http.get("/online-store/rest/categories/get").success(function(data) {
        catalog.categories = data;

        catalog.categoriesLoadedCallback();
    });

    this.offersLoadingCallback = function() {
        this.offersInitialized = true;
        if ($state.params.page) {
            this.currentPage = $state.params.page;
        }
    };

    this.categoriesLoadedCallback = function() {
        this.categoriesInitialized = true;
        if ($state.params.category) {
            this.currentCategory = $state.params.category;
        }
    };

    this.setPageUrl = function() {
        if (this.offersInitialized && this.categoriesInitialized) {
            var params = {
                page: this.currentPage,
                category: this.currentCategory
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