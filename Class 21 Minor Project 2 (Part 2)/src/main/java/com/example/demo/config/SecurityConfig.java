package com.example.demo.config;

import com.example.demo.service.UserService;
import com.example.demo.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    /**Authentication*/
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }

    @Bean /**AUTHORIZATION*/
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/student/create").permitAll()
                            .requestMatchers("/admin/**").hasAuthority(Constants.CREATE_ADMIN_AUTHORITY)
                            .requestMatchers("/student/profile").hasAuthority(Constants.STUDENT_SELF_INFO_AUTHORITY)
                            .requestMatchers("/book/**").hasAuthority(Constants.CREATE_BOOK_AUTHORITY)
                            .requestMatchers("/transaction/**").hasAuthority(Constants.INITIATE_TRANSACTION_AUTHORITY)
                            .requestMatchers("/**").authenticated()).formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
