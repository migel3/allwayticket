
schedulerApp.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider
        .when('/train-search-by-route/:from -- :to/:dateP1', {
            templateUrl: 'html/trains-by-route.html',
            controller: 'trainByRouteController',
            reloadOnSearch: false
        })
        .when('/train-search-by-route/:from -- :to', {
            templateUrl: 'html/trains-by-route.html',
            controller: 'trainByRouteController',
            reloadOnSearch: false
        })
        .when('/stations/:id', {
            templateUrl: 'html/stations.html',
            controller: 'stationController',
            reloadOnSearch: false
        })

        .when('/train-search-by-station/:station', {
            templateUrl: 'html/trains-by-station.html',
            controller: 'trainByStationController',
            reloadOnSearch: false
        })
        .when('/train-search-by-station/:station/:dateP2', {
            templateUrl: 'html/trains-by-station.html',
            controller: 'trainByStationController',
            reloadOnSearch: false
        })
        .otherwise({
            redirectTo: '/',
            reloadOnSearch: false
        });
}]);
