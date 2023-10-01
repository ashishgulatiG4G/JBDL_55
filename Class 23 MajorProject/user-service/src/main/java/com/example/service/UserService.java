package com.example.service;

import com.example.models.User;
import com.example.repository.UserCacheRepository;
import com.example.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCacheRepository userCacheRepository;

    private static final String USER_CREATE_TOPIC = "user_created";

    private ObjectMapper objectMapper = new ObjectMapper();
    public void create(User user) throws JsonProcessingException {
        userRepository.save(user);

        JSONObject userObject = new JSONObject();
        userObject.put("phone", user.getPhone());
        userObject.put("userId", user.getId());
        userObject.put("email", user.getEmail());

        kafkaTemplate.send(USER_CREATE_TOPIC, this.objectMapper.writeValueAsString(userObject));
    }

    public User find(Integer UserId) {
        User user = userCacheRepository.get(UserId);
        if(user != null) {
            return user;
        }

        user = userRepository.findById(UserId).orElse(null);
        if(user != null) {
            userCacheRepository.set(user);
        }
        return user;
    }
}
