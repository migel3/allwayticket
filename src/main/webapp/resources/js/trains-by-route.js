var schedulerApp = angular.module('schedulerApp');
schedulerApp.controller('trainByRouteController', function ($scope, trainFactory) {
    $scope.swapToTab1();

    console.log('trainByRouteController.create');

    var that;
    if ($scope.routeParams.dateP1 === undefined)
        that = trainFactory.getTrainsByRoute($scope.routeParams);
    else
        that = trainFactory.getTrainsByRouteAndDate($scope.routeParams);

    that.then(function (success) {
        $scope.trains = success.data;
        $scope.changeEachOnTheWayDate($scope.trains);

    }, function (error) {
        console.log(error, 'can not get data.');
    });


    $scope.filterAdvanced1 = function (trainItem) {

        if ($scope.advancedElem.timeFrom1 === null) {

            $scope.advancedElem.timeFrom1 = new Date(1970, 0, 1, 0, 0);
        }
        if ($scope.advancedElem.timeTo1 === null) {

            $scope.advancedElem.timeTo1 = new Date(1970, 0, 1, 23, 59);

        }
        var splitTimeDeparture = trainItem.timeDeparture.split(":");
        var dateDeparture = new Date(1970, 0, 1, splitTimeDeparture[0], splitTimeDeparture[1]);


        return ((dateDeparture >= $scope.advancedElem.timeFrom1 ) &&
        (dateDeparture <= $scope.advancedElem.timeTo1))
        /* &&
         ( trainItem.train.trainType === $scope.advancedElem.high ||
         trainItem.train.trainType === $scope.advancedElem.fast ||
         trainItem.train.trainType === $scoper.advancedElem.passenger)*/
    };

});
