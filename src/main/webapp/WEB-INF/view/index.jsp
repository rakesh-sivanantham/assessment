<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="assessment">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Assessment</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
<div ng-controller="mainCtrl">
    <div>
        <h3>{{editMode ? "Modify Employee" : "Create Employee"}}</h3>
        <form name="empForm" ng-submit="save(employee)">
            <table>
                <tr><td colspan="2"><input type="text" placeholder="Name" name="name" ng-model="employee.name" required></td></tr>
                <tr><td colspan="2"><input type="text" placeholder="Lives In" name="livesIn" ng-model="employee.livesIn" required></td></tr>
                <tr><td colspan="2">Gender:</td></tr>
                <tr>
                    <td><input type="radio" name="gender" ng-model="employee.gender" value="MALE" id="genMale" required><label for="genMale">Male</label></td>
                    <td><input type="radio" name="gender" ng-model="employee.gender" value="FEMALE" id="genFemale"><label for="genFemale">Female</label></td>
                </tr>
                <tr><td colspan="2">
                    <button type="submit">{{editMode ? "Save" : "Create"}}</button>
                    <button type="reset" ng-click="cancel()" ng-show="editMode">Cancel</button>
                </td></tr>
            </table>

        </form>
        <font color="green">{{createdStatus}}</font>
    </div>
    <br>
    <div ng-init="getEmployees()">
        <table border="1" cellpadding="5" ng-show="employees.length>0 && !editMode">
            <thead><tr><th>Name</th><th>Lives In</th><th>Gender</th><th></th></tr></thead>
            <tbody>
                <tr ng-repeat="e in employees">
                    <td>{{e.name}}</td>
                    <td>{{e.livesIn}}</td>
                    <td>{{e.gender}}</td>
                    <td>
                        <a href="#" ng-click="editEmployee(e)">EDIT</a> /
                        <a href="#" ng-click="deleteEmployee(e)">DELETE</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
