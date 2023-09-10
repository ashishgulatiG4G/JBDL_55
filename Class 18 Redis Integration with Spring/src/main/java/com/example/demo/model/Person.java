package com.example.demo.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {

    private String id;

    private String name;

    private String age;

    private Address address;
}
