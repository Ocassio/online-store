portalControllers.controller("SignInController", function($scope, $http, $modalInstance) {

    $scope.submit = function(form) {
        if (form.$valid) {
            console.log("Form successfully submitted");
        }
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

});