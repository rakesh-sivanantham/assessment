package com.capgemini.assessment.dao.daoImpl;

import com.capgemini.assessment.dao.EmployeeDao;
import com.capgemini.assessment.models.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * A method to get all the employee info
     * @return List
     */
    @Override
    public List<EmployeeDto> getEmployees(){
        return mongoTemplate.findAll(EmployeeDto.class);
    }

    /**
     * A method to update specific employee details
     * @param employeeDto
     * @return boolean
     */
    @Override
    public boolean updateEmployee(EmployeeDto employeeDto){
        try {
            mongoTemplate.save(employeeDto);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * A method to delete specific employee using the employeeId
     * @param empId
     * @return boolean
     */
    @Override
    public boolean deleteEmployee(String empId){
        EmployeeDto employeeDto = mongoTemplate.findById(empId, EmployeeDto.class);
        if(employeeDto==null) return false;
        try{
            mongoTemplate.remove(employeeDto);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * create a new employee
     * @param employeeDto
     * @return
     */
    @Override
    public String createEmployee(EmployeeDto employeeDto){
        try{
            mongoTemplate.insert(employeeDto);
        } catch (Exception e){
            return null;
        }
        return employeeDto.getId();
    }

}
