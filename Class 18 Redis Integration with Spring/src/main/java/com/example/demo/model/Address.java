package com.example.demo.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {

    private String street;

    private String city;

    private String state;

    private String country;

}
