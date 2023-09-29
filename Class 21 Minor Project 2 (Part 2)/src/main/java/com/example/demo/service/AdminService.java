package com.example.demo.service;


import com.example.demo.models.Admin;
import com.example.demo.models.SecuredUser;
import com.example.demo.repository.AdminRepository;
import com.example.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    AdminRepository adminRepository;

    public void createAdmin(Admin admin) {
        SecuredUser securedUser = admin.getSecuredUser();
        securedUser = userService.save(securedUser, Constants.ADMIN_USER);

        admin.setSecuredUser(securedUser);
        adminRepository.save(admin);
    }

    public Admin find(Integer adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

}
