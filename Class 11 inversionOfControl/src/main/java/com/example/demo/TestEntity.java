package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestEntity {

    private Logger logger = LoggerFactory.getLogger(TestEntity.class);

//    public TestEntity() {
//    }


    // For IOC to work properly, there needs to be either a default constructor or a parametrised
    // constructor where parameter need to be bean itself




    public TestEntity() {
        logger.info("TestEntityCreated : {}", this);
    }




    // constructor dependency injection

//    @Autowired // -> needed if we have multiple paramterised constructors which are taking beans as parameter
//    public TestEntity(TestService testService) {
//    }


    public TestEntity(String name) {
        this.name = name;
    }




    public String getName() {
        logger.info("Object is:" + this);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
