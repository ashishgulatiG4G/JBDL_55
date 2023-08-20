package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {


//    private String name = "Mike";
//    public ValueController() {
//        System.out.println("name = " + name);
//    }


    /**
     * Whenever we want to use variables inside constructor, always use constructor injection and not field injection
     */

    // Field Injection
    @Value("${prop.bot.name}")
    private String name;

    public ValueController() {
        System.out.println("name = " + name);
    }


//    Constructor Injection
    public ValueController(@Value("${prop.bot.name}") String name) {
        System.out.println("name = " + name);
        this.name = name;
    }


    /**
     * How Java Class is instantiated ??
     * Variables get intialised first and then the constructor gets called
     */

    /**
     * When we add $Value -> Constructor will be called first and then the variables will be initialised
     */

    /**
     * The way instance attributes are declared in java is not the same when we autowire the attribute values in spring
     */



    @GetMapping("/hello")
    public String sayHello() {
        return "Hello " + this.name;
    }





}
