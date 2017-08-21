var app = angular.module('assessment', []);
app.controller('mainCtrl', function($scope, $http) {
    $scope.employees = [];
    $scope.editMode = false;

    /**
     * Create new employee or modify existing employee
     * @param employee
     * @returns {boolean}
     */
    $scope.save = function (employee) {
        var url = '/employee/';
        var method;
        if(employee.id==undefined) {
            method='POST';
            url+='createEmployee';
        } else {
            method='PUT';
            url+='updateEmployee';
        }
        $http({method: method, url: url,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                for(var p in obj)
                    str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                return str.join("&");
            },
            data: employee
        }).then(function (response) {
            if(!$scope.editMode && response.data.status){
                employee.id = response.data.empId;
                var emp = angular.copy(employee);
                $scope.employees.push(emp);
                $scope.createdStatus = "Employee created successfully";
                $scope.employee = {};
                $scope.empForm.$setPristine();
            } else if($scope.editMode && response.data){
                $scope.createdStatus = "Changes saved successfully";
                for(var i=0; i<$scope.employees.length; i++){
                    if($scope.employee.id==$scope.employees[i].id) $scope.employees[i] = angular.copy($scope.employee);
                }
                $scope.cancel();
            }
        }, function (err) {
            console.log(err);
        });
        return false;
    };

    /**
     * Get list of employees
     */
    $scope.getEmployees = function () {
        $http({method: 'GET', url:'/employee/getEmployees'})
            .then(function (response) {
                $scope.employees = response.data;
            }, function (err) {
                console.log(err);
            });
    };

    /**
     * Delete existing employee
     * @param emp
     */
    $scope.deleteEmployee = function (emp) {
        $http({method: 'DELETE', url:'/employee/deleteEmployee?empId='+emp.id})
            .then(function (response) {
                if(response.data){
                    $scope.employees.splice($scope.employees.indexOf(emp), 1);
                }
            }, function (err) {
                console.log(err);
            });
    };

    /**
     * Enable edit mode for an employee
     * @param emp
     */
    $scope.editEmployee = function (emp) {
        $scope.employee = angular.copy(emp);
        $scope.editMode = true;
    };

    /**
     * Close edit mode and show list of employees
     */
    $scope.cancel = function () {
        $scope.editMode = false;
        $scope.employee = {};
        $scope.empForm.$setPristine();
    };
});