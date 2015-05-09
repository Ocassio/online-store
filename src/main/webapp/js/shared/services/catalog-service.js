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

        addOffer: function() {

        },

        editOffer: function() {

        },

        deleteOffer: function(offerId) {

        }

        /**
         * ------------------------------------------------------------------
         * ---------              Private methods                   ---------
         * ------------------------------------------------------------------
         */



    };

    return service;
});