package com.capgemini.assessment.services.serviceImpl;

import com.capgemini.assessment.dao.EmployeeDao;
import com.capgemini.assessment.models.EmployeeDto;
import com.capgemini.assessment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * A service to get all the employees
     * @return
     */
    @Override
    public List<EmployeeDto> getEmployees(){
        return employeeDao.getEmployees();
    }

    /**
     * update details of specific employee
     * @param employeeDto
     * @return
     */
    @Override
    public boolean updateEmployee(EmployeeDto employeeDto){
        return employeeDao.updateEmployee(employeeDto);
    }

    /**
     * delete specific employee using empId
     * @param empId
     * @return
     */
    @Override
    public boolean deleteEmployee(String empId){
        return employeeDao.deleteEmployee(empId);
    }

    /**
     * create a new employee
     * @param employeeDto
     * @return
     */
    @Override
    public Map<String, Object> createEmployee(EmployeeDto employeeDto){
        String empId = employeeDao.createEmployee(employeeDto);
        Map<String, Object> response = new HashMap<>();
        if(empId!=null){
            response.put("status", true);
            response.put("empId", empId);
        } else response.put("status", false);
        return response;
    }

}
