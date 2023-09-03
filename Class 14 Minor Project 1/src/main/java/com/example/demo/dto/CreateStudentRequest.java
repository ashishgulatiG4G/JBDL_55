package com.example.demo.dto;


import com.example.demo.models.Student;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String rollNumber;

    @NotNull
    private Integer age;

    public Student toStudent() {
        return Student.builder()
                .name(this.name)
                .age(this.age)
                .rollNumber(this.rollNumber)
                .email(this.email)
                .build();
    }


}
