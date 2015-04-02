portal.controller("CatalogController", function($http) {

    var portal = this;

    this.totalItems = 0;
    this.itemsPerPage = 6;
    this.currentPage = 1;
    this.maxSize = 5;

    this.setPage = function(page) {
        this.currentPage = page;
    };

    this.pageChanged = function() {

    };

    this.offers = [];

    $http.get("/online-store/rest/offers/getAllOffers").success(function(data) {
        portal.offers = data;
        portal.totalItems = data.length;
    });

});