portalControllers.controller("CatalogController", ['$http','shoppingCart','$scope','$state', function($http, shoppingCart, $scope,$state) {
    console.log('Start CatalogController');
    var catalog = this;

    this.totalItems = 0;
    this.itemsPerPage = 6;
    this.maxSize = 5;
    this.maxRating = 5;


    $scope.paramObj = {'currentPage': '1'};

    this.offers = [];

    $http.get("/online-store/rest/offers/get").success(function(data) {
        catalog.offers = data;
        catalog.totalItems = data.length;
    });

    this.categories = [];

    $http.get("/online-store/rest/categories/get").success(function(data) {
        catalog.categories = data;
    });

    $scope.test = function()
    {
        console.log('Test function: ' + $scope.currentPage);
    }

    this.setPageUrl = function()
    {
        console.log("setPageUrl CurrentPage: " + $scope.paramObj.currentPage);
        $state.go('catalog.params', {'page':$scope.paramObj.currentPage});
    };

}]);

portalControllers.controller('ParamsController', ['$scope','$state', function($scope, $state){
    console.log('Start Page Controller');
    $scope.paramObj.currentPage = $state.params.page;
    console.log('Current Page on Child Controller = ' + $scope.paramObj.currentPage);


}])