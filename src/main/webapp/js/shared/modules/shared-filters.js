var sharedFilters = angular.module("shared.filters", []);

sharedFilters.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});