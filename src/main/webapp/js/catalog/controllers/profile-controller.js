catalogControllers.controller("ProfileController", function($rootScope, $scope, $state, user) {

    if (!user.isSignedIn()) {
        $state.go('login');
        return;
    }

    $scope.disableUpdateButton = false;
    $scope.disableChangePasswordButton = false;

    $scope.profile = user.info;

    $scope.form = {
        email: user.info.email,
        name: user.info.name,
        surname: user.info.surname,
        address: user.info.address
    };

    $scope.updateProfile = function(form) {
        if (form.$invalid) return;

        $scope.closeAllAlerts();
        $scope.disableUpdateButton = true;

        user.update(form.email.$modelValue, form.name.$modelValue, form.surname.$modelValue, $scope.form.address).success($scope.onUpdate.bind(this, form));
    };

    $scope.onUpdate = function(form, response) {
        $scope.showAlert(response, "Profile has been successfully updated");
        $scope.disableUpdateButton = false;
        if (response.success) {
            form.$setPristine();
        }
    };

    $scope.changePassword = function(form) {
        if (form.$invalid) return;

        $scope.closeAllAlerts();
        $scope.disableChangePasswordButton = true;

        user.changePassword(form.password.$modelValue, form.oldPassword.$modelValue).success($scope.onPasswordChange.bind(this, form));
    };

    $scope.onPasswordChange = function(form, response) {
        $scope.showAlert(response, "Password has been successfully changed");
        $scope.disableChangePasswordButton = false;
        if (response.success) {
            form.$setPristine();
            $scope.form.password = "";
            $scope.form.confirmation = "";
            $scope.form.oldPassword = "";
        }
    };

    $scope.showAlert = function(response, successMessage) {
        if (response.success) {
            $scope.addAlert("success", successMessage);
        } else if (response.error) {
            $scope.addAlert("danger", response.error);
        } else {
            $scope.addAlert('danger', "Something went wrong");
        }
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