var schedulerApp = angular.module('schedulerApp');
schedulerApp.factory("trainFactory", function ($http, baseUrl) {

        var runRouteRequest = function (search) {
            return $http({
                method: 'GET',
                url: baseUrl.train + '/route/' + search.from + '/' + search.to

            });
        };
        var runRouteRequestWithDate = function (search) {
            return $http({
                method: 'GET',
                url: baseUrl.train + '/route/' + search.from + '/' + search.to + '/' + search.dateP1

            });
        };
        var runStationRequest = function (search) {
            return $http({
                method: 'GET',
                url: baseUrl.train + '/st/' + search.station

            });
        };
        var runStationRequestWithDate = function (search) {
            return $http({
                method: 'GET',
                url: baseUrl.train + '/st/' + search.station + '/' + search.dateP2

            });
        };
        return {
            getTrainsByRoute: function (searchRoute) {
                return runRouteRequest(searchRoute);
            },
            getTrainsByRouteAndDate: function (searchRoute) {
                return runRouteRequestWithDate(searchRoute);
            },
            getTrainsByStation: function (searchStation) {
                return runStationRequest(searchStation);
            },
            getTrainsByStationAndDate: function (searchStation) {
                return runStationRequestWithDate(searchStation);
            }
        };

    })

    .factory("stationFactory", function ($http, baseUrl) {
        return {
            getStationsByTrain: function (id) {
                return $http.get(baseUrl.station + '/' + id);
            },
            getAllStationName: function () {
                return $http.get(baseUrl.station + '/findAll');
            }

        };
    });
