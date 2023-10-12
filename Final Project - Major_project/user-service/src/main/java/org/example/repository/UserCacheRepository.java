package org.example.repository;

import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserCacheRepository {

    public static final String USER_CACHE_KEY_PREFIX = "usr::";
    public static final Integer USER_CACHE_KEY_EXPIRY = 600;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public User get(Integer userId){
        Object result = redisTemplate.opsForValue().get(getKey(userId));
        return (result == null) ? null :  (User) result;
    }

    public void set(User user){
        redisTemplate.opsForValue()
                .set(getKey(
                        user.getId()),
                        user,
                        USER_CACHE_KEY_EXPIRY,
                        TimeUnit.SECONDS);
    }

    private String getKey(Integer userId){
        return USER_CACHE_KEY_PREFIX + userId;
    }
}
