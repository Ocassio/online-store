portalServices.factory("shoppingCart", function($http, user) {
    var service =  {

        /**
         * ------------------------------------------------------------------
         * ---------                Public API                      ---------
         * ------------------------------------------------------------------
         */

        offers: [],
        deliveryAddress: null,

        add: function(offer, count) {
            var path = "/online-store/rest/cart/add/" + offer.id;
            var params = {count: count};

            return $http.get(path, params).success(this.onOfferAdded.bind(this, offer));
        },

        remove: function(offer, count) {
            var path = "/online-store/rest/cart/remove/" + offer.id;
            var params = {count: count};

            return $http.get(path, params).success(this.onOfferRemoved.bind(this, offer));
        },

        clear: function() {
            return $http.get("/online-store/rest/cart/clear").success(this.onClear.bind(this));
        },

        isInCart: function(offer) {
            return _.some(this.offers, this.offerMatcher, offer);
        },

        isEmpty: function() {
            return this.offers.length === 0;
        },

        getTotal: function() {
            var total = 0;
            for (var i = 0; i < this.offers.length; i++) {
                total += +this.offers[i].price;
            }
            return total;
        },

        isDeliveryAddressCustom: function() {
            if (this.deliveryAddress && this.deliveryAddress !== user.info.address) {
                return true;
            }
            return false;
        },

        getDeliveryAddress: function() {
            if (this.deliveryAddress) {
                return this.deliveryAddress;
            } else {
                return user.info.address;
            }
        },

        submit: function() {
            return $http.get("/online-store/rest/cart/submit").success(this.clear.bind(this));
        },

        /**
         * ------------------------------------------------------------------
         * ---------              Private methods                   ---------
         * ------------------------------------------------------------------
         */

        init: function() {
            this.loadOffers();
        },

        loadOffers: function() {
            $http.get("/online-store/rest/cart/get").success(this.onOffersLoaded.bind(this));
        },

        onOffersLoaded: function(response) {
            this.offers = response;
        },

        onOfferAdded: function(offer) {
            this.offers.push(offer);
        },

        onOfferRemoved: function(offer) {
            this.offers =  _.reject(this.offers, this.offerMatcher, offer);
        },

        onClear: function() {
            this.offers.splice(0, this.offers.length);
        },

        onSubmit: function(response) {
            if (response.success) {
                this.onClear();
            }
        },

        offerMatcher: function(offer) {
            return this.id === offer.id;
        }

    };

    service.init();

    return service;
});