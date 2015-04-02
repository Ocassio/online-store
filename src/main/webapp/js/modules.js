var portal = angular.module("portal", ["ui.bootstrap"]);

portal.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});