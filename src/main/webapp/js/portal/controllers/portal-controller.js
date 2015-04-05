portalControllers.controller("PortalController", function($http, $modal) {

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