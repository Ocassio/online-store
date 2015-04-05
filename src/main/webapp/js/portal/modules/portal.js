var portal = angular.module("portal", ["ui.bootstrap", "portal.controllers", "portal.filters", "portal.directives","ngRoute"]);

portal.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/',
        {
            templateUrl: 'views/portal-catalog.html',
            controller: 'CatalogController',
            controllerAs: 'catalogCtrl'
        })
        .otherwise({redirectTo: '/'});
}]);