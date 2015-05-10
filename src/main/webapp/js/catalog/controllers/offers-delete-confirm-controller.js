catalogControllers.controller("OffersDeleteConfirmController", function($scope, $modalInstance) {

    $scope.submit = function() {
        $modalInstance.close();
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

});