portal.directive("portalHeader", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-header.html"
    };
});

portal.directive("portalCategories", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-categories.html"
    };
});

portal.directive("portalOffersList", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-offers-list.html"
    };
});

portal.directive("portalOffersPagination", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-offers-pagination.html"
    };
});