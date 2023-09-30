package com.example.demo.controller;

import com.example.demo.dto.CreateAdminRequest;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public void createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest) {
        adminService.createAdmin(createAdminRequest.toAdmin());
    }



}
