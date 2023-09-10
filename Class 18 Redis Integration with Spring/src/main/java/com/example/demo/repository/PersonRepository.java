package com.example.demo.repository;

import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class PersonRepository {


    private static final String PERSON_KEY_PREFIX = "person::";
    private static final String PERSON_LIST_KEY = "person_list";
    private static final String PERSON_HASH_KEY_PREFIX = "person_hash::";
    private static final Integer PERSON_VALUE_EXPIRY = 1;

    private

    @Autowired
    RedisTemplate<String, Person> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;


    public void set(Person person) {
        String key = getKey(person.getId());
        this.redisTemplate.opsForValue().set(key, person, PERSON_VALUE_EXPIRY, TimeUnit.DAYS);
    }

    public String getKey(String personId) {
        return PERSON_KEY_PREFIX + personId;
    }


    public Set<String> getAllKeysStartingWithPrefix() {
        return this.redisTemplate.keys(PERSON_KEY_PREFIX + "*");
    }

    public Person getByKey(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }



    // List Operations
    public void lpush(Person person) {
        redisTemplate.opsForList().leftPush(PERSON_LIST_KEY, person);
    }

    public void rpush(Person person) {
        redisTemplate.opsForList().rightPush(PERSON_LIST_KEY, person);
    }

    public void lpop(int counter) {
        redisTemplate.opsForList().leftPop(PERSON_LIST_KEY, counter);
    }

    public void rpop(int counter) {
        redisTemplate.opsForList().rightPop(PERSON_LIST_KEY, counter);
    }

    public List<Person> lrange(int start, int end) {
        return redisTemplate.opsForList().range(PERSON_LIST_KEY, start, end);
    }


    // Hash Operations
    public void hmset(Person person) {
        Map map = objectMapper.convertValue(person, Map.class);
        this.redisTemplate.opsForHash().putAll(getKeysForHash(person.getId()), map);
    }

    public Person hgetAll(String personId) {
        Map map = this.redisTemplate.opsForHash().entries(getKeysForHash(personId));
        return objectMapper.convertValue(map, Person.class);
    }

    String getKeysForHash(String personId) {
        return PERSON_HASH_KEY_PREFIX + personId;
    }
}
