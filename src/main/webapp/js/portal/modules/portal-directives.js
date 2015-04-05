var portalDirectives = angular.module("portal.directives", []);

portalDirectives.directive("portalHeader", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-header.html"
    };
});

portalDirectives.directive("portalCategories", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-categories.html"
    };
});

portalDirectives.directive("portalOffersList", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-offers-list.html"
    };
});

portalDirectives.directive("portalOffersPagination", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal-offers-pagination.html"
    };
});