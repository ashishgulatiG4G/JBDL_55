package com.example.demojpa.dto;

import com.example.demojpa.model.Employee;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequest {

//    // TODO - Remove, Server should generate the ID, we will remove it once we know how to generate the ID's
//    // Client shouldn't pass it
//    private Integer id;

    @NotEmpty
    private String name;

    @Max(60)
    @Min(18)
    @NotNull
    private int age;
    private String address;

    public Employee toEmployee() {
        return Employee.builder().
                name(this.name).
                address(this.address).
                age(this.age).build();
    }

}

/**
 Builder design pattern -> Separate the constructor of a complex object
          from its representation so that same construction process can create different representations

*/


