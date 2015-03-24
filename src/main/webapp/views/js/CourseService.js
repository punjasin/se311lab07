/**
 * Created by Punjasin on 24/3/2558.
 */
'use strict'
var courseServices = angular.module('courseServices',['ngResource']);
courseServices.factory('courseServices',function($resource){
    return $resource('/course/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});
})
