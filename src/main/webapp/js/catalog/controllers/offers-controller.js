catalogControllers.controller("OffersController", function($rootScope, $scope, $http, $state, user) {

    if (!user.isSignedIn()) {
        $state.go("login");
    }

    this.offers = [];

    $http.get("/online-store/rest/offers/get").success(function(data) {
        this.offers = data;
    }.bind(this));

    this.onAdd = function() {

    };

    this.onEdit = function() {

    };

    this.onDelete = function() {

    };

    $scope.$on($rootScope.consts.events.ADD, this.onAdd.bind(this));
    $scope.$on($rootScope.consts.events.EDIT, this.onEdit.bind(this));
    $scope.$on($rootScope.consts.events.DELETE, this.onDelete.bind(this));

});