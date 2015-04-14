var portal = angular.module("portal", ["ui.bootstrap", "ui.router",
    "portal.controllers", "portal.filters", "portal.directives", "portal.services"]);

portal.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.otherwise('/catalog');
    $stateProvider
        .state('catalog', {
            url: '/catalog',
            views: {
                'offers': {
                    controller: 'CatalogController as catalogCtrl',
                    templateUrl: 'views/portal-catalog.html'
                }
            }
        })
        .state('catalog.params', {
            url: '?page&category&search',
            views: {
                'pagination' : {
                    controller: 'ParamsController as paramsCtrl'
                }
            }
        })
        .state('cart', {
            url: '/cart',
            templateUrl: 'views/portal-cart.html'

        });
}]);