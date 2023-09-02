package com.example.demojpa.controller;

import com.example.demojpa.daos.AdminRepository;
import com.example.demojpa.dto.CreateAdminRequest;
import com.example.demojpa.dto.CreateEmployeeRequest;
import com.example.demojpa.model.Admin;
import com.example.demojpa.model.Employee;
import com.example.demojpa.service.AdminService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/createAdmin")
    public String createEmployee(@RequestBody @Valid CreateAdminRequest createAdminRequest) {
        // conversion of DTO to a model
        Admin admin = createAdminRequest.toAdmin();
        adminService.save(admin);
        return "ADMIN ACCEPTED";
    }

}
