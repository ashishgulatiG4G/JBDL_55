package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    // Field Injection
    @Autowired
    TestEntity testEntity;

    @GetMapping("/test")
    public String sayHello(){
        testEntity.getName();
        return "Hello user!!";
    }
}


// Object is:com.example.demo.TestEntity@723e2c8e
// Object is:com.example.demo.TestEntity@753524dd



//VS


//        Object is:com.example.demo.TestEntity@37979057
//        Object is:com.example.demo.TestEntity@37979057
//        Object is:com.example.demo.TestEntity@37979057