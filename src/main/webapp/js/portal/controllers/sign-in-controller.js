portalControllers.controller("SignInController", function($scope, $http, $modal, $modalInstance, user) {

    $scope.disableSubmitButton = false;

    $scope.submit = function(form) {
        $scope.closeAllAlerts();

        if (form.$valid) {
            $scope.disableSubmitButton = true;
            user.signIn(form.email.$modelValue, form.password.$modelValue).success($scope.onSubmit);
        }
    };

    $scope.onSubmit = function(response) {
        if (response.success) {
            $modalInstance.close();
        } else if (response.error) {
            $scope.addAlert('danger', response.error);
        } else {
            $scope.addAlert('danger', "Something went wrong");
        }
        $scope.disableSubmitButton = false;
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

    $scope.showSignUpForm = function() {
        $scope.cancel();
        $modal.open({
            templateUrl: "views/portal/portal-sign-up-form.html",
            controller: "SignUpController"
        });
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