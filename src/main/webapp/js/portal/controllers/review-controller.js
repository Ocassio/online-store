portalControllers.controller("ReviewController", function($scope, $state, user, shoppingCart) {

    if (!user.isSignedIn() || shoppingCart.isEmpty()) {
        $state.go('catalog');
        return;
    }

    $scope.disableSubmitButton = false;

    $scope.submit = function() {
        $scope.disableSubmitButton = true;
        shoppingCart.submit().success($scope.onSubmit);
    };

    $scope.onSubmit = function(response) {
        $scope.disableSubmitButton = false;
        if (response.success) {
            $state.go('congrats');
        }
    };

    $scope.back = function() {
        $state.go('payment');
    };

});