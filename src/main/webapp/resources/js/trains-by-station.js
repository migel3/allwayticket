var schedulerApp = angular.module('schedulerApp');
schedulerApp.controller('trainByStationController', function ($scope, trainFactory) {
        $scope.swapToTab2();
    console.log('trainByStationController.create');
        if ($scope.routeParams.dateP2 === undefined)
            that = trainFactory.getTrainsByStation($scope.routeParams);
        else
            that = trainFactory.getTrainsByStationAndDate($scope.routeParams);

        that.then(function (success) {
            $scope.trains = success.data;


        }, function (error) {
            console.log(error, 'can not get data.');
        });


        $scope.filterAdvanced2 = function (trainItem) {

            var baseDateFrom = new Date(1970, 0, 1, 0, 0);
            var baseDateTo = new Date(1970, 0, 1, 23, 59);
            if ($scope.advancedElem.timeFrom2 === null) {
                $scope.advancedElem.timeFrom2 = baseDateFrom;

            }
            if ($scope.advancedElem.timeTo2 === null) {
                $scope.advancedElem.timeTo2 = baseDateTo;

            }
            if (trainItem.timeDeparture !== null) {
                var splitTimeDeparture = trainItem.timeDeparture.split(":");
                var dateDeparture = new Date(1970, 0, 1, splitTimeDeparture[0], splitTimeDeparture[1]);
            }

            return ( (($scope.advancedElem.timeFrom2.getTime() === baseDateFrom.getTime())
            && ($scope.advancedElem.timeTo2.getTime() === baseDateTo.getTime()))
            || ((dateDeparture >= $scope.advancedElem.timeFrom2) && (dateDeparture <= $scope.advancedElem.timeTo2)))

        };

    });
