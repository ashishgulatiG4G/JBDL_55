package com.example.demo.repository;

import com.example.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

import static com.example.demo.util.Constants.STUDENT_CACHE_KEY_EXPIRY;
import static com.example.demo.util.Constants.STUDENT_KEY_PREFIX;

@Repository
public class StudentCacheRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public Student get(Integer studentId) {
        Object result = redisTemplate.opsForValue().get(getKey(studentId));
        return result == null ? null : (Student) result;
    }

    public void set(Student student) {
        redisTemplate.opsForValue().set(getKey(student.getId()), student, STUDENT_CACHE_KEY_EXPIRY, TimeUnit.MINUTES);
    }

    public String getKey(Integer studentId) {
        return STUDENT_KEY_PREFIX + studentId;
    }



}
