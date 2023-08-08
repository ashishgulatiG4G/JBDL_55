package com.example.springstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Base url : Domain name / IP_address:port
 *
 * Steps to write an api
 * 1. Define an HTTP method (Request Method)
 * 2. Define the endpoint/ API path
 * 3. Define how to take input
 *
 */

@RestController
public class EmployeeController {


    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @GetMapping("/logTest")
    public String sayHello() {
        logger.debug("The log test api has been triggered");
        logger.error("The log test api has been triggered");
        logger.trace("The log test api has been triggered");
        logger.warn("The log test api has been triggered");
        logger.info("The log test api has been triggered");
        /// Logic


        ///

        // The logic has been performed




        return "hello";
    }


    // id -> employee
    private HashMap<Integer, Employee> employeeHashMap = new HashMap<>();

//    @GetMapping("/complete/search1")
//    public String sayHelloWorld1(@RequestParam String name1) {
//        return "Hello World, " + name1;
//    }
//
//    @GetMapping("/complete/search/{name1}/{name}")
//    public String sayHelloWorld(@PathVariable("name") String name2, @PathVariable String name1) {
//        return "Hello World, " + name2 + " " + name1;
//    }

//    @GetMapping("/createEmployee/{id}")
//    public void createEmployee(@PathVariable int id) {
//        this.employeeHashMap.put(id, new Employee());
//    }

    // Request Body -> json type request body


    @PostMapping("/createEmployee")
    public void createEmployee1(@RequestBody Employee employee) {
        this.employeeHashMap.put(employee.getId(), employee);
    }

    @GetMapping("/getEmployees")
    public HashMap<Integer, Employee> getEmployees() {
        return this.employeeHashMap;
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        return this.employeeHashMap.get(id);
    }


    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = this.employeeHashMap.get(employee.getId());

        this.employeeHashMap.put(employee.getId(), employee);
        return employeeHashMap.get(employee.getId());
    }

    @PatchMapping("/employee/id/{id}")
    public Employee patchUpdateEmployee(@RequestBody Employee employee) {
        Employee existingEmployee = this.employeeHashMap.get(employee.getId());

        if(employee.getAge() != null) {
            existingEmployee.setAge(employee.getAge());
        }

        if(employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }

        return this.employeeHashMap.put(employee.getId(), existingEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return this.employeeHashMap.remove(id);
    }
}

// Spring boot -> Spring + bootstrapping
