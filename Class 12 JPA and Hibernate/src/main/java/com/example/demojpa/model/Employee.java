package com.example.demojpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    @Column(name="homeAddress")
    private String address;

}
