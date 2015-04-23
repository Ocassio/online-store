portalControllers.controller("ChooseAddressController", function($scope, $state, user, shoppingCart) {

    if (!user.isSignedIn() || shoppingCart.isEmpty()) {
        $state.go('catalog');
        return;
    }

    $scope.disableCustomAddress = true;

    var customAddress = "";
    if (shoppingCart.isDeliveryAddressCustom()) {
        customAddress = shoppingCart.getDeliveryAddress();
        $scope.disableCustomAddress = false;
    }

    $scope.form = {
        isCustom: shoppingCart.isDeliveryAddressCustom(),
        defaultAddress: user.info.address,
        customAddress: customAddress
    };

    $scope.onIsCustomChange = function() {
        $scope.disableCustomAddress = !$scope.form.isCustom;
    };

    $scope.submit = function() {
        if ($scope.isCustomAddressValid()) {
            if ($scope.form.isCustom) {
                shoppingCart.deliveryAddress = $scope.form.customAddress;
            }

            $state.go('payment')
        }
    };

    $scope.back = function() {
        $state.go('cart');
    };

    $scope.isCustomAddressValid = function() {
        return !$scope.form.isCustom || $scope.form.customAddress.length > 0
    };

});