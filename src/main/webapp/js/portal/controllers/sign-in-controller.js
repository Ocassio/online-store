portalControllers.controller("SignInController", function($scope, $http, $modalInstance) {

    $scope.submit = function(form) {
        $scope.closeAllAlerts();

        if (form.$valid) {
            var path = "/online-store/rest/auth/signIn";
            var params = {
                email: form.email.$modelValue,
                password: CryptoJS.SHA256(form.password.$modelValue).toString()
            };

            $http.put(path, params).success(function(response) {
                if (response.success) {
                    $scope.addAlert('success', "You've been successfully signed in");
                } else if (response.error) {
                    $scope.addAlert('danger', response.error);
                } else {
                    $scope.addAlert('danger', "Something went wrong");
                }
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