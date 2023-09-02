package com.example.demojpa.service;

import com.example.demojpa.daos.AdminRepository;
import com.example.demojpa.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void save(Admin admin) {
        adminRepository.save(admin);
    }





}
