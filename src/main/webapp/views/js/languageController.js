'use strict';
var langController=
    angular.module('languageControllers',['$scope','$translate','$location',
    function($scope,$translate,$location){
    $scope.changeLanguage=function(locale){
        $translate.use(locale);
        $location.search('lang',locale);
    }
}])