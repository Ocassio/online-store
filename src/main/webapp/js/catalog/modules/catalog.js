var catalog = angular.module("catalog", ["ui.bootstrap", "ui.router",
    "catalog.controllers", "catalog.directives", "catalog.services", "shared.services"]);

catalog.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.otherwise('/offers');
    $stateProvider
        .state('offers', {
            url: '/offers',
            controller: 'OffersController as offersCtrl',
            templateUrl: 'views/catalog/catalog-offers.html'
        })
        .state('login', {
            url: '/login',
            //controller: 'LoginController as loginCtrl',
            templateUrl: 'views/catalog/catalog-login.html'
        });
}]);