catalogControllers.controller("OffersController", function($state, user) {

    if (!user.isSignedIn()) {
        $state.go("login");
    }

});