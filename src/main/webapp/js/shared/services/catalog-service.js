sharedServices.factory("catalog", function($http) {
    var service =  {

        /**
         * ------------------------------------------------------------------
         * ---------                Public API                      ---------
         * ------------------------------------------------------------------
         */

        getCategories: function() {
            return $http.get("/online-store/rest/categories/get");
        },

        getOffers: function() {
            return $http.get("/online-store/rest/offers/get");
        },

        addOffer: function(offer) {
            var params = {
                offer: offer
            };

            return $http.put("/online-store/rest/offers/add", params);
        },

        editOffer: function(offer) {
            var params = {
                offer: offer
            };

            return $http.put("/online-store/rest/offers/edit", params);
        },

        deleteOffer: function(offerId) {
            return $http.get("/online-store/rest/offers/delete/" + offerId);
        }

        /**
         * ------------------------------------------------------------------
         * ---------              Private methods                   ---------
         * ------------------------------------------------------------------
         */



    };

    return service;
});