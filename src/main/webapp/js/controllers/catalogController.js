portal.controller("CatalogController", function($http) {

    var portal = this;
    this.offers = [];

    $http.get("/online-store/rest/offers/getAllOffers").success(function(data) {
        portal.offers = data;
    });

});