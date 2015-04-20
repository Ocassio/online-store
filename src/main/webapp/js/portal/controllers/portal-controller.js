portalControllers.controller("PortalController", function($rootScope, $scope, $state, $location, $modal, shoppingCart, user) {

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

    $scope.user = user;

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

    this.signOut = function() {
        user.signOut().success(function() {
            if (!$state.is('catalog')) {
                $state.go('catalog');
            }
        });
    };

});