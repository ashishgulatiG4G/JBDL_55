package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

    /**Authentication
     * */

    /**
     * In memory user details
     *
     *
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails ADMIN = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails USER1 = User.withUsername("ashish")
                .password(passwordEncoder.encode("ashish"))
                .roles("USER")
                .build();
        UserDetails USER2 = User.withUsername("john")
                .password(passwordEncoder.encode("john"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(ADMIN,USER1,USER2);
    }
     */

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserInfoUserDetailsService();
    }

    @Bean /**AUTHORIZATION*/
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/", "/product/all", "/product/{name}","/user/save").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/user/all","/product/save", "user/{name}").authenticated()
                .and().formLogin()
                .and().build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
