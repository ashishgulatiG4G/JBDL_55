package com.example.demo.dto;


import com.example.demo.model.Address;
import com.example.demo.model.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonCreateRequest {

    @NotBlank
    private String name;

    private String age;

    private Address address;

    public Person toPerson() {
        return Person.builder()
                .age(this.age)
                .name(this.name)
                .address(this.address)
                .id(UUID.randomUUID().toString())
                .build();
    }



}
