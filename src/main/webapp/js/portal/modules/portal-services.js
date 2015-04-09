var portalServices = angular.module("portal.services", []);

portalServices.factory("shoppingCart", function() {
    return {

        offers: [],

        add: function(offer) {
            this.offers.push(offer);
        },

        remove: function(offer) {
            this.offers =  _.reject(this.offers, this.removeReject, offer);
        },

        removeReject: function(offer) {
            return this.id === offer.id;
        }

    };
});