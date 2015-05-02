var portalDirectives = angular.module("portal.directives", []);

portalDirectives.directive("portalHeader", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal/portal-header.html"
    };
});

portalDirectives.directive("portalCategories", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal/portal-categories.html"
    };
});

portalDirectives.directive("portalOffersList", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal/portal-offers-list.html"
    };
});

portalDirectives.directive("portalOffersPagination", function() {
    return {
        restrict: "E",
        templateUrl: "views/portal/portal-offers-pagination.html"
    };
});

portalDirectives.directive('match', function ($parse) {
    return {
        require: 'ngModel',
        restrict: "A",
        link: function (scope, elem, attrs, ctrl) {
            if(!ctrl) {
                if(console && console.warn){
                    console.warn('Match validation requires ngModel to be on the element');
                }
                return;
            }

            var matchGetter = $parse(attrs.match);

            scope.$watch(getMatchValue, function(){
                ctrl.$$parseAndValidate();
            });

            ctrl.$validators.match = function(){
                return ctrl.$viewValue === getMatchValue();
            };

            function getMatchValue(){
                var match = matchGetter(scope);
                if(angular.isObject(match) && match.hasOwnProperty('$viewValue')){
                    match = match.$viewValue;
                }
                return match;
            }
        }
    }
});