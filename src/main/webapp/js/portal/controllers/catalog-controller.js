portalControllers.controller("CatalogController", function($http, shoppingCart) {

    var catalog = this;

    this.totalItems = 0;
    this.itemsPerPage = 6;
    this.currentPage = 1;
    this.maxSize = 5;

    this.maxRating = 5;

    this.setPage = function(page) {
        this.currentPage = page;
    };

    this.offers = [];

    $http.get("/online-store/rest/offers/get").success(function(data) {
        catalog.offers = data;
        catalog.totalItems = data.length;
    });

    this.categories = [];

    $http.get("/online-store/rest/categories/get").success(function(data) {
        catalog.categories = data;
    });

});