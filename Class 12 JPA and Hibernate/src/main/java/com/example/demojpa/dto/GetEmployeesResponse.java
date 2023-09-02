package com.example.demojpa.dto;

import com.example.demojpa.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeesResponse {
    List<Employee> employeeList;
}
