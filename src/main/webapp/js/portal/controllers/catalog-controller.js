portalControllers.controller("CatalogController", function($http, $modal) {

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

    this.addToCart = function (offer, count) {
        var path = "/online-store/rest/offers/add/" + offer.id;
        var params = {count: count};

        $http.get(path, params).success(function() {
            offer.inCart = true;
        });
    };

    this.removeFromCart = function(offer, count) {
        var path = "/online-store/rest/offers/remove/" + offer.id;
        var params = {count: count};

        $http.get(path, params).success(function() {
            offer.inCart = false;
        });
    };

    this.showSignInForm = function() {
        $modal.open({
            templateUrl: "views/portal-sign-in-form.html",
            controller: "SignInController",
            size: "sm"
        });
    };

});