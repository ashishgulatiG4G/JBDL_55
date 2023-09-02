package com.example.demojpa.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "employee_table")
public class Employee {

    // 1. Identity - Underlying DB will generate an id
    // 2. AUTO - Hibernate will generate an id and pass it in the insert query
    // 3. UUID ->


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
//    @Column(name="homeAddress")
    private String address;

    // lower in case
    // Camel Case -> homeAddress -> home_address



}
