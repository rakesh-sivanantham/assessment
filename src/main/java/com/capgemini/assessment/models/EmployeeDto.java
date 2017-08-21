package com.capgemini.assessment.models;

import com.capgemini.assessment.enums.Gender;
import com.capgemini.assessment.utils.MongoDBCollections;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = MongoDBCollections.EMPLOYEES)
public class EmployeeDto {
    @Id
    private String id;
    private String name;
    private String livesIn;
    private Gender gender;

    public EmployeeDto(){}

    public EmployeeDto(String name, String livesIn, String gender){
        this.name = name;
        this.livesIn = livesIn;
        this.gender = Gender.valueOf(gender);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLivesIn() {
        return livesIn;
    }

    public void setLivesIn(String livesIn) {
        this.livesIn = livesIn;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
