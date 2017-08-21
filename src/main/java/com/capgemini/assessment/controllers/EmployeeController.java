package com.capgemini.assessment.controllers;

import com.capgemini.assessment.models.EmployeeDto;
import com.capgemini.assessment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * get all employees
     * @return
     */
    @RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * update existing employee
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    public boolean updateEmployees(@RequestBody MultiValueMap<String,String> requestBody) {
        EmployeeDto employeeDto = new EmployeeDto(requestBody.getFirst("name"), requestBody.getFirst("livesIn"), requestBody.getFirst("gender"));
        employeeDto.setId(requestBody.getFirst("id"));
        return employeeService.updateEmployee(employeeDto);
    }

    /**
     * create a new employee
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public Map<String, Object> createEmployees(@RequestBody MultiValueMap<String,String> requestBody) {
        EmployeeDto employeeDto = new EmployeeDto(requestBody.getFirst("name"), requestBody.getFirst("livesIn"), requestBody.getFirst("gender"));
        return employeeService.createEmployee(employeeDto);
    }

    /**
     * delete existing employee
     * @param empId
     * @return
     */
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public boolean deleteEmployee(@RequestParam String empId) {
        return employeeService.deleteEmployee(empId);
    }
}
