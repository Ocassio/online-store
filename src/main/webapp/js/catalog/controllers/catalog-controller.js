catalogControllers.controller("CatalogController", function($rootScope, $scope, $state, user) {

    /**
     * ------------------------------------------------------------------
     * ---------             Global constants                   ---------
     * ------------------------------------------------------------------
     */

    $rootScope.consts = {
        routing: {
            TRANSITION_WITHOUT_RELOADING_OPTIONS: { notify: false, location: true }
        },
        events: {
            ADD: 'add',
            EDIT: 'edit',
            DELETE: 'delete'
        }
    };

    /**
     * ------------------------------------------------------------------
     */

    $scope.user = user;

    $scope.signOut = function() {
        user.signOut().success(function() {
            $state.go("login");
        });
    };

    $scope.add = function() {
        $scope.$broadcast($rootScope.consts.events.ADD);
    };

    $scope.edit = function() {
        $scope.$broadcast($rootScope.consts.events.EDIT);
    };

    $scope.delete = function() {
        $scope.$broadcast($rootScope.consts.events.DELETE);
    };

    $scope.isMenuVisible = function() {
        return $state.is("offers");
    };

});