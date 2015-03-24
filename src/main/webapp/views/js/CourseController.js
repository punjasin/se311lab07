'use strict';
var CourseMainController = angular.module('CourseMainController', ['courseServices']);
CourseMainController.controller('addCourseController', ['$scope', '$http', '$location', '$rootScope','courseServices',
    function ($scope, $http, $location, $rootScope,courseServices) {
        $scope.course = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addProduct = function () {
//$http.post("/product", $scope.product).success(function () {
            courseServices.save($scope.course,function(){
                $rootScope.addSuccess = true;
                $location.path("listCourse");
            });
        };
    }]);
CourseMainController.controller('listCourseController', ['$scope', '$http', '$rootScope','courseServices','$route',
    function ($scope, $http, $rootScope,courseServices) {
//$http.get("/product/").success(function (data) {
        var data = courseServices.query(function(){

            $scope.courses = data;
        });
        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });
        $scope.deleteProduct = function (id) {
            var answer = confirm("Do you want to delete the Course?");
            if (answer) {
                courseServices.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }
    }]);
CourseMainController.controller('editCourseController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','courseServices',
    function ($scope, $http, $routeParams, $location, $rootScope,courseServices) {
        $scope.addPerson = false;
        $scope.editPerson = true;
        var id = $routeParams.id;
        $http.get("/course/" + id).success(function (data) {
            $scope.course = data;
        });
        $scope.editCourse = function () {
//$http.put("/product", $scope.product).then(function () {
            courseServices.update({id:$scope.Course.id},$scope.course,function(){
                $rootScope.editSuccess = true;
                $location.path("listCourse");
            });
        }
    }]);