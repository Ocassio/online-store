portalControllers.controller("CatalogController", function($rootScope, $http, shoppingCart, $scope, $state) {

    var catalog = this;

    this.totalItems = 0;
    this.itemsPerPage = 6;
    this.maxSize = 5;
    this.maxRating = 5;

    this.currentPage = 1;

    this.offersInitialized = false;

    this.offers = [];

    $http.get("/online-store/rest/offers/get").success(function(data) {
        catalog.offers = data;
        catalog.totalItems = data.length;

        catalog.offersLoadingCallback();
    });

    this.categories = [];

    $http.get("/online-store/rest/categories/get").success(function(data) {
        catalog.categories = data;
    });

    this.offersLoadingCallback = function() {
        this.offersInitialized = true;
        if ($state.params.page) {
            this.currentPage = $state.params.page;
        }
    };

    this.setPageUrl = function() {
        if (this.offersInitialized) {
            $state.transitionTo('catalog', {'page': this.currentPage}, $rootScope.consts.routing.TRANSITION_WITHOUT_RELOADING_OPTIONS);
        }
    };

});