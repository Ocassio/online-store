catalogControllers.controller("LoginController", function($scope, user, $state) {

    if (user.isSignedIn()) {
        $state.go("offers");
    }

});