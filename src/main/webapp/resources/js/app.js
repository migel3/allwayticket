var schedulerApp = angular.module('schedulerApp', ['ngRoute', 'ui.timepicker', 'ui.bootstrap']);
schedulerApp
    .constant('baseUrl', {
        train: '/trains',
        station: '/stations'
    })
    .controller('schedulerCtrl', [
        '$scope', '$log', '$route', '$routeParams', '$location', 'stationFactory',
        function (scope, console, route, routeParams, location,stationFactory) {
            console.log('schedulerCtrl.create');

             stationFactory.getAllStationName().then(function (success) {
                 scope.sts = success.data;
            }, function (error) {
                console.log(error, 'can not get data.');
            });

            // scope.sts = ['Brest', 'Gomel', 'Minsk', 'Mogilev', 'Grodno', 'Vitebsk'];


            scope.showTab1 = true;
            scope.showTab2 = false;
            scope.showAdvanced1 = false;
            scope.showAdvanced2 = false;

            scope.swapToTab1 = function () {
                scope.showTab1 = true;
                scope.showTab2 = false;

            };
            scope.swapToTab2 = function () {
                scope.showTab1 = false;
                scope.showTab2 = true;


            };

            scope.advancedElem = {
                timeFrom1: null,
                timeTo1: null,
                timeFrom2: null,
                timeTo2: null,
                checkboxModel: {
                    high: false,
                    fast: false,
                    passenger: false
                }
            };

            scope.options = {
                step: 30,
                timeFormat: 'H:i',
                asMoment: true
            };

            scope.routeParams = routeParams;

            scope.numberToText = function (value) {
                var numbers = value.match(/\d+/g);
                var date = new Date(numbers[2], numbers[0] - 1, numbers[1], numbers[3], numbers[4]);
                if (date.getDate() !== 1) return date.getDate() - 1 + ' d ' + date.getHours() + ' h ' + date.getMinutes() + ' m';
                return date.getHours() + ' h ' + date.getMinutes() + ' m';
            };
            scope.changeEachOnTheWayDate = function (value) {
                for (var i = 0; i < value.length; i++) {
                    if (value[i].onTheWay !== null) {
                        value[i].onTheWay = scope.numberToText(value[i].onTheWay);
                    }
                }
            }
        }])





    .directive("datepickerer", function () {
        return {
            restrict: "A",
            require: "ngModel",
            link: function (scope, elem, attrs, ngModelCtrl) {
                var updateModel = function (dateText) {
                    scope.$apply(function () {
                        ngModelCtrl.$setViewValue(dateText);
                    });
                };
                var options = {
                    dateFormat: "dd-mm-yy",
                    onSelect: function (dateText) {
                        updateModel(dateText);
                    }
                };
                $(elem).datepicker(options);

            }
        }
    });













