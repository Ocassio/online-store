catalogControllers.controller("CatalogController", function($scope, $state, user) {

    $scope.user = user;

    $scope.signOut = function() {
        user.signOut().success(function() {
            $state.go("login");
        });
    };

});