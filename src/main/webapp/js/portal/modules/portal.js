var portal = angular.module("portal", ["ui.bootstrap", "ui.router",
    "portal.controllers", "portal.filters", "portal.directives", "portal.services"]);

portal.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.otherwise('/catalog');
    $stateProvider
        .state('catalog', {
            url: '/catalog?page&category',
            controller: 'CatalogController as catalogCtrl',
            templateUrl: 'views/portal-catalog.html'
        })
        .state('cart', {
            url: '/cart',
            templateUrl: 'views/portal-cart.html',
            controller: 'CartController as cartCtrl'
        })
        .state('profile', {
            url: '/profile',
            templateUrl: 'views/portal-profile.html',
            controller: 'ProfileController as profileCtrl'
        })
        .state('chooseAddress', {
            url: '/choose-address',
            templateUrl: 'views/portal-choose-address.html',
            controller: 'ChooseAddressController as addressCtrl'
        })
        .state('payment', {
            url: '/payment',
            templateUrl: 'views/portal-payment.html',
            controller: "PaymentController as paymentCtrl"
        });
}]);