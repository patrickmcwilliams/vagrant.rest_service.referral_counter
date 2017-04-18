angular.module('app', [])
  .controller('main', function($scope, $http) {
     $http.get('/counter/get/?action=topThree').
        then(function(response) {
            $scope.referrerOne = response.data[0];
            $scope.referrerTwo = response.data[1];
            $scope.referrerThree = response.data[2];
        });
});
