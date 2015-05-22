catalogControllers.controller("OffersEditController", function($scope, $modalInstance, $timeout, catalog, offer) {

    $scope.MODE = "edit";

    $scope.disableSubmitButton = false;

    $scope.form = offer;

    $scope.form.price = parseFloat(offer.price);

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
        $scope.form.category = offer.category;
        this.refreshSelectPickers();
    }.bind(this));

    $scope.submit = function() {
        $scope.disableSubmitButton = true;

        $scope.form.category = _.find($scope.categories, function(category) {
            return category.id === $scope.form.category.id;
        });

        catalog.addOffer($scope.form).success(this.onAdd);
    }.bind(this);

    this.onAdd = function(response) {
        if (response.success) {
            $modalInstance.close(response.data);
        } else {
            $scope.addAlert("danger", response.error);
            $scope.disableSubmitButton = false;
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

    $timeout(this.initDOM);

});