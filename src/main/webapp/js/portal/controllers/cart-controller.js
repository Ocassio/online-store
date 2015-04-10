portalControllers.controller("CartController", function($modal, shoppingCart) {

    this.clear = function() {
        var dialog = $modal.open({
            templateUrl: "views/portal-cart-clear-confirm.html",
            controller: "CartClearConfirmController"
        });

        dialog.result.then(this.onConfirm);
    };

    this.onConfirm = function() {
        shoppingCart.clear();
    };

});