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
            //var params = {
            //    offer: offer
            //};

            return $http.post("/online-store/rest/offers/add", offer);

            //return $http({
            //    method: 'POST',
            //    url: "/online-store/rest/offers/add",
            //    headers: {
            //        'Content-Type': 'multipart/form-data'
            //    },
            //    data: {
            //        offer: offer,
            //        images: null
            //    }
            //});
        },

        editOffer: function(offer) {
            return $http.put("/online-store/rest/offers/edit", offer);
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