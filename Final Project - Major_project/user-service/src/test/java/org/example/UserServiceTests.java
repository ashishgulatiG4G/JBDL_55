package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.models.User;
import org.example.repository.UserCacheRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @InjectMocks
    UserService userService;

    @Mock
    KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserCacheRepository userCacheRepository;

    @Test()
    public void testUserCreation() throws JsonProcessingException {

        User user = User.builder()
                .name("ABC")
                .username("ABC123")
                .password("pass")
                .age(20)
                .build();

        String dummyEncodedPassword = "wqfregstewadear214";

        when(passwordEncoder.encode(user.getPassword())).thenReturn(dummyEncodedPassword);
        when(userRepository.save(any())).thenReturn(null);
        when(kafkaTemplate.send(eq(CommonConstants.USER_CREATED_TOPIC), any())).thenReturn(null);

        userService.create(user);

        verify(userRepository, times(1)).save(any());
        verify(kafkaTemplate, times(1))
                .send(eq(CommonConstants.USER_CREATED_TOPIC), any());
        verify(passwordEncoder, times(1)).encode(any());

        assertEquals(dummyEncodedPassword, user.getPassword());
    }

    @Test()
    public void testUserRetrieval_CacheHit() throws Exception {

        int userId = 1;

        User user = User.builder()
                .id(1)
                .name("DEF")
                .age(20)
                .build();

        when(userCacheRepository.get(eq(userId))).thenReturn(user);

        userService.get(userId);

        verify(userCacheRepository, times(1)).get(eq(userId));
        verify(userRepository, times(0)).findById(eq(userId));
    }

    @Test()
    public void testUserRetrieval_CacheMiss() throws Exception {

        int userId = 1;

        User user = User.builder()
                .id(1)
                .name("DEF")
                .age(20)
                .build();

        when(userCacheRepository.get(eq(userId))).thenReturn(null);
        when(userRepository.findById(eq(userId))).thenReturn(Optional.of(user));
        doNothing().when(userCacheRepository).set(user);

        userService.get(userId);

        verify(userCacheRepository, times(1)).get(userId);
        verify(userRepository, times(1)).findById(eq(userId));
        verify(userCacheRepository, times(1)).set(eq(user));
    }

    @Test(expected = BadCredentialsException.class)
    public void testUserRetrieval_DBMiss() throws Exception {

        int userId = 1;

        when(userCacheRepository.get(eq(userId))).thenReturn(null);
        when(userRepository.findById(eq(userId))).thenReturn(Optional.empty());

        userService.get(userId);

        verify(userCacheRepository, times(1)).get(userId);
        verify(userRepository, times(1)).findById(eq(userId));


    }
}
