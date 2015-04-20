portalControllers.controller("SignUpController", function($scope, $http, $modalInstance, user) {

    $scope.disableSubmitButton = false;

    $scope.submit = function(form) {

        $scope.closeAllAlerts();

        if (form.$valid) {
            $scope.disableSubmitButton = true;
            user.signUp(form.email.$modelValue, form.password.$modelValue,
                form.name.$modelValue, form.surname.$modelValue, form.address.$modelValue)
                .success(function(response) {
                    if (response.success) {
                        $modalInstance.close();
                    } else if (response.error) {
                        $scope.addAlert('danger', response.error);
                    } else {
                        $scope.addAlert('danger', "Something went wrong");
                    }
                 $scope.disableSubmitButton = false;
                });
        }
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

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