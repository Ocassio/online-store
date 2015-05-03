catalogControllers.controller("LoginController", function($scope, user, $state) {

    if (user.isSignedIn()) {
        $state.go("offers");
    }

    $scope.disableSubmitButton = false;

    $scope.submit = function(form) {
        if (form.$valid) {
            $scope.disableSubmitButton = true;
            user.signIn($scope.form.email, $scope.form.password).success($scope.onSubmit);
        }
    }

    $scope.onSubmit = function(response) {
        if (response.success) {
            $state.go("offers");
        }
        $scope.disableSubmitButton = false;
    }

});