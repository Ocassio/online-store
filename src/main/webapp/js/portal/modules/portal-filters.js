var portalFilters = angular.module("portal.filters", []);

portalFilters.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});