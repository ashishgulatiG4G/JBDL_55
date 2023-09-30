package com.example.demo;

import com.example.demo.models.Admin;
import com.example.demo.models.SecuredUser;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L21MinorProject implements CommandLineRunner {

	@Autowired
	AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(L21MinorProject.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Admin admin = Admin.builder().
//				name("admin").
//				email("admin@gmail.com").
//				securedUser(SecuredUser.builder().
//						username("admin").
//						password("password").
//						build()).
//				build();
//
//		adminService.createAdmin(admin);
	}
}
