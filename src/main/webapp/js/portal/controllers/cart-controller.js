portalControllers.controller("CartController", function($modal, shoppingCart) {

    this.selectedOffer = null;

    this.removeSelectedDisabled = false;

    this.clear = function() {
        var dialog = $modal.open({
            templateUrl: "views/portal-cart-clear-confirm.html",
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

});