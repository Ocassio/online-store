catalogControllers.controller("OffersController", function($http, $state, user) {

    if (!user.isSignedIn()) {
        $state.go("login");
    }

    this.offers = [];

    $http.get("/online-store/rest/offers/get").success(function(data) {
        this.offers = data;
    }.bind(this));

});