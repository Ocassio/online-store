portalControllers.controller("CartController", function($rootScope, $scope, $modal, shoppingCart, user, $state) {

    this.selectedOffer = null;

    this.removeSelectedDisabled = false;

    this.clear = function() {
        var dialog = $modal.open({
            templateUrl: "views/portal/portal-cart-clear-confirm.html",
            controller: "CartClearConfirmController"
        });

        dialog.result.then(this.onConfirm.bind(this));
    };

    this.onConfirm = function() {
        this.selectedOffer = null;
        shoppingCart.clear();
    };

    this.isSelected = function(offer) {
        return offer === this.selectedOffer;
    };

    this.select = function(offer) {
        if (!this.isSelected(offer)) {
            this.selectedOffer = offer;
        } else {
            this.selectedOffer = null;
        }
    };

    this.removeSelected = function() {
        if (this.selectedOffer) {
            this.removeSelectedDisabled = true;
            shoppingCart.remove(this.selectedOffer).success(this.onRemoved.bind(this));
        }
    };

    this.onRemoved = function() {
        this.selectedOffer = null;
        this.removeSelectedDisabled = false;
    };

    this.nextStep = function() {
        $state.go('chooseAddress');
    };

    this.proceed = function() {
        if (user.isSignedIn()) {
             this.nextStep();
        } else {
            $scope.$emit($rootScope.consts.events.SHOW_SIGN_IN_FORM, this.nextStep);
        }
    };

});