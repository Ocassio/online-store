portalControllers.controller("PortalController", function($scope, $location, $modal, shoppingCart) {

    $scope.shoppingCart = shoppingCart;

    var portal = this;

    this.go = function(path) {
        $location.path(path);
    };

    this.searchText = "";

    this.showSignInForm = function() {
        $modal.open({
            templateUrl: "views/portal-sign-in-form.html",
            controller: "SignInController",
            size: "sm"
        });
    };

});