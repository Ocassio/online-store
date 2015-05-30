portalControllers.controller("PortalController", function($rootScope, $scope, $state, $location, $modal, shoppingCart, user) {

    /**
     * ------------------------------------------------------------------
     * ---------             Global constants                   ---------
     * ------------------------------------------------------------------
     */

    $rootScope.consts = {
        routing: {
            TRANSITION_WITHOUT_RELOADING_OPTIONS: { notify: false, location: true }
        },
        events: {
            SHOW_SIGN_IN_FORM: 'showSignInForm'
        }
    };

    /**
     * ------------------------------------------------------------------
     */

    $scope.user = user;

    $scope.shoppingCart = shoppingCart;

    shoppingCart.loadOffers();

    var portal = this;

    this.go = function(path) {
        $location.path(path);
    };

    this.searchText = "";

    this.showSignInForm = function(event, callback) {
        var signInForm = $modal.open({
            templateUrl: "views/portal/portal-sign-in-form.html",
            controller: "SignInController",
            size: "sm"
        });

        signInForm.result.then(callback);
    };

    this.signOut = function() {
        user.signOut().success(function() {
            if (!$state.is('catalog')) {
                $state.go('catalog');
            }
        });
    };

    $scope.$on($rootScope.consts.events.SHOW_SIGN_IN_FORM, this.showSignInForm);

});