package com.example.demo.service;

import com.example.demo.models.SecuredUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.authoritiesListProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.demo.util.Constants.INVALID_USER_TYPE;

@Configuration
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        return userDetails;
    }

    public SecuredUser save(SecuredUser securedUser, String userType) {
        String encryptedPassword = passwordEncoder.encode(securedUser.getPassword());
        String authorities = authoritiesListProvider.getAuthorities(userType);
        if(authorities.equals(INVALID_USER_TYPE)) {
            return new SecuredUser();
        }

        securedUser.setAuthorities(authorities);
        securedUser.setPassword(encryptedPassword);
        return userRepository.save(securedUser);

    }

}
