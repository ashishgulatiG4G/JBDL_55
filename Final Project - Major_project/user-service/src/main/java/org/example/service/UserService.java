package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.CommonConstants;
import org.example.models.User;
import org.example.repository.UserCacheRepository;
import org.example.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCacheRepository userCacheRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void create(User user) throws JsonProcessingException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities("usr");
        userRepository.save(user);

        JSONObject userObj = new JSONObject();
        userObj.put("phone", user.getUsername());
        userObj.put("email", user.getEmail());

        kafkaTemplate.send(CommonConstants.USER_CREATED_TOPIC,
                this.objectMapper.writeValueAsString(userObj));
    }

    public User get(int userId) {
        User user = userCacheRepository.get(userId);
        if(user != null){
            return user;
        }

        // get data from Repository
        user = userRepository.findById(userId).orElseThrow(() -> new BadCredentialsException(""));
        // Add data to cache
        userCacheRepository.set(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
