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

    this.categories = ["Apps","Games","Movies","Books","Newspapper"];
    this.currentTab = this.categories[0];

    this.setCurrentTab = function(choosenTab) {
        this.currentTab = choosenTab;
    };

    this.getCurrentTab = function() {
        return this.currentTab;
    };

    this.isTabSelected = function(checkTab) {
        return this.currentTab === checkTab;
    };

});