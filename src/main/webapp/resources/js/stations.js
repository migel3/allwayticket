var schedulerApp = angular.module('schedulerApp');
schedulerApp.controller('stationController', function ($scope, stationFactory, $routeParams) {
    console.log('stationController.create');
    $scope.trainId = $routeParams.id;
    var stationsByTrain = stationFactory.getStationsByTrain($routeParams.id);
    stationsByTrain.then(function (success) {
        $scope.stations = success.data;

        $scope.changeEachOnTheWayDate($scope.stations);

    }, function (error) {
        console.log(error, 'can not get data.');
    });


});
