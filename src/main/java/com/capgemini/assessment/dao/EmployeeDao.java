package com.capgemini.assessment.dao;

import com.capgemini.assessment.models.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    List<EmployeeDto> getEmployees();
    boolean updateEmployee(EmployeeDto employeeDto);
    boolean deleteEmployee(String empId);

    String createEmployee(EmployeeDto employeeDto);
}
