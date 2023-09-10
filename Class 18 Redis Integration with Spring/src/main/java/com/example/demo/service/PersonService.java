package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void create(Person person) {
        personRepository.set(person);
    }

    public List<Person> get() {
        Set<String> keys = personRepository.getAllKeysStartingWithPrefix();
        return keys.stream()
                .map(k -> personRepository.getByKey(k))
                .collect(Collectors.toList());
    }


    // List Operations
    public void lpush(Person person) {
        personRepository.lpush(person);
    }

    public void rpush(Person person) {
        personRepository.rpush(person);
    }

    public void lpop(int counter) {
        personRepository.lpop(counter);
    }

    public void rpop(int counter) {
        personRepository.rpop(counter);
    }

    public List<Person> lrange(int start, int end) {
        return personRepository.lrange(start, end);
    }

    public void setPersonInHash(Person person) {
        personRepository.hmset(person);
    }

    public Person getPersonFromHash(String personId) {
        return personRepository.hgetAll(personId);
    }
}
