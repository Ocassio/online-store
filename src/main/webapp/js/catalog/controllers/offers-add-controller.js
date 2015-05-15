catalogControllers.controller("OffersAddController", function($scope, $modalInstance, $timeout, catalog) {

    $scope.MODE = "add";

    this.initDOM = function() {
        $('.selectpicker').selectpicker();
    };

    this.refreshSelectPickers = function() {
        $timeout(function() {
            $('.selectpicker').selectpicker('refresh');
        });
    }

    $scope.categories = [];

    catalog.getCategories().success(function(data) {
        $scope.categories = data;
        this.refreshSelectPickers();
    }.bind(this));

    $scope.submit = function() {

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

    $timeout(this.initDOM);

});