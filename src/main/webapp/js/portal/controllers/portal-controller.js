portalControllers.controller("PortalController", function($rootScope, $scope, $location, $modal, shoppingCart, user) {

    /**
     * ------------------------------------------------------------------
     * ---------             Global constants                   ---------
     * ------------------------------------------------------------------
     */

    $rootScope.consts = {
        routing: {
            TRANSITION_WITHOUT_RELOADING_OPTIONS: { notify: false, location: true }
        }
    };

    /**
     * ------------------------------------------------------------------
     */

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

    user.init().success(function() {
        console.log(user.info);
    });


});