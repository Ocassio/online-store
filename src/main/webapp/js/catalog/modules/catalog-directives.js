var catalogDirectives = angular.module("catalog.directives", ["shared.directives"]);

catalogDirectives.directive("catalogHeader", function() {
    return {
        restrict: "E",
        templateUrl: "views/catalog/catalog-header.html"
    };
});