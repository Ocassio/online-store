portalControllers.controller("PortalController", function($scope, $http, $modal, shoppingCart) {

    $scope.shoppingCart = shoppingCart;

    var portal = this;

    this.searchText = "";

    this.showSignInForm = function() {
        $modal.open({
            templateUrl: "views/portal-sign-in-form.html",
            controller: "SignInController",
            size: "sm"
        });
    };

});