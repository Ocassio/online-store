var portal = angular.module("portal", ["ui.bootstrap", "ui.router",
    "portal.controllers", "shared.filters", "portal.directives", "portal.services",
    "shared.services"]);

portal.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.otherwise('/catalog');
    $stateProvider
        .state('catalog', {
            url: '/catalog?page&category',
            controller: 'CatalogController as catalogCtrl',
            templateUrl: 'views/portal/portal-catalog.html'
        })
        .state('cart', {
            url: '/cart',
            templateUrl: 'views/portal/portal-cart.html',
            controller: 'CartController as cartCtrl'
        })
        .state('profile', {
            url: '/profile',
            templateUrl: 'views/portal/portal-profile.html',
            controller: 'ProfileController as profileCtrl'
        })
        .state('chooseAddress', {
            url: '/choose-address',
            templateUrl: 'views/portal/portal-choose-address.html',
            controller: 'ChooseAddressController as addressCtrl'
        })
        .state('payment', {
            url: '/payment',
            templateUrl: 'views/portal/portal-payment.html',
            controller: "PaymentController as paymentCtrl"
        })
        .state('review', {
            url: '/review',
            templateUrl: 'views/portal/portal-review.html',
            controller: 'ReviewController as reviewCtrl'
        })
        .state('congrats', {
            url: '/congrats',
            templateUrl: 'views/portal/portal-congratulations.html'
        });
}]);