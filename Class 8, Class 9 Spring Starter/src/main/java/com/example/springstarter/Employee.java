package com.example.springstarter;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Employee {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Integer age;


    /**
     * Regular annotations -> To provide additional information
     */
//    @Override
//    public String toString() {
//        return "This is a custom toString()";
//    }

    /**
     * Lombok annotations -> Automatically generate code based on annotated elements
     */
//    @Override
//    public String toString() {
//        return "Employee(name=" + name + ", id=" + id + ", age=" + age + ")";
//    }
//
//    public void




}
