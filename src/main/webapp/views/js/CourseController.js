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



            $scope.getCourse = function(){
                $http.get('http://localhost:8080/course/name/name.json',
                    {params:{name:$scope.name}}).success(function(data){
                        $scope.courses = data;
                    })
            }
            $scope.getCourse();
        $scope.getCourseid = function(){
            $http.get('http://localhost:8080/course/name/id.json',
                {params:{id:$scope.id}}).success(function(data){
                    $scope.courses = data;
                })
        }
        $scope.getCourseid();


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
            courseServices.update({id:$scope.course.id},$scope.course,function(){
                $rootScope.editSuccess = true;
                $location.path("listCourse");
            });
        }
    }]);

CourseMainController.controller('ViewCourseController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','courseServices',
    function ($scope, $http, $routeParams, $location, $rootScope,courseServices) {
        $scope.addPerson = false;
        $scope.editPerson = false;
        var name = $routeParams.name;
        $http.get("/course/" +name+"/search").success(function (data) {
            $scope.course = data;
        });
        $scope.deleteProduct = function (id) {
            var answer = confirm("Do you want to delete the product?");
            if (answer) {
                productService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }
    }]);