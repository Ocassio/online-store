var sharedDirectives = angular.module("shared.directives", []);

sharedDirectives.directive("sharedPagination", function() {
    return {
        restrict: "E",
        templateUrl: "views/shared/shared-pagination.html"
    };
});