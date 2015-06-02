var catalog = angular.module("catalog", ["ui.bootstrap", "ui.router", "blueimp.fileupload",
    "catalog.controllers", "catalog.directives", "catalog.services", "shared.services", "shared.filters"]);

catalog.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.otherwise('/offers');
    $stateProvider
        .state('offers', {
            url: '/offers?page',
            controller: 'OffersController as offersCtrl',
            templateUrl: 'views/catalog/catalog-offers.html'
        })
        .state('login', {
            url: '/login',
            controller: 'LoginController as loginCtrl',
            templateUrl: 'views/catalog/catalog-login.html'
        });
}]);