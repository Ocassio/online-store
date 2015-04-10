var portal = angular.module("portal", ["ui.bootstrap", "ngRoute",
    "portal.controllers", "portal.filters", "portal.directives", "portal.services"]);

portal.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/',
        {
            templateUrl: 'views/portal-catalog.html',
            controller: 'CatalogController',
            controllerAs: 'catalogCtrl'
        })
        .when('/cart',
        {
            templateUrl: 'views/portal-cart.html',
            controller: "CartController",
            controllerAs: "cartCtrl"
        })
        .otherwise({redirectTo: '/'});
}]);