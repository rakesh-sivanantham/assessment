package com.capgemini.assessment.services;

import com.capgemini.assessment.models.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();

    boolean updateEmployee(EmployeeDto employeeDto);

    boolean deleteEmployee(String empId);

    Map<String, Object> createEmployee(EmployeeDto employeeDto);
}
