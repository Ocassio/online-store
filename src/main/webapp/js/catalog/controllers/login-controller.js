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
        } else if (response.error) {
            $scope.addAlert('danger', response.error);
        } else {
            $scope.addAlert('danger', "Something went wrong");
        }
        $scope.disableSubmitButton = false;
    }

    $scope.alerts = [];

    $scope.addAlert = function(type, message) {
        $scope.alerts.push({type: type, message: message});
    };

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.closeAllAlerts = function() {
        $scope.alerts.splice(0, $scope.alerts.length);
    };

});