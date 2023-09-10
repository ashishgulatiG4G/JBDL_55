package com.example.demo.controller;

import com.example.demo.dto.PersonCreateRequest;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    /**
     * String operations
     */
    @PostMapping("/create")
    public void createPerson(@RequestBody PersonCreateRequest personCreateRequest) {
        personService.create(personCreateRequest.toPerson());
    }

    @GetMapping("/getall")
    public List<Person> getPeoples() {
        return personService.get();
    }

    // TODO - Another get mapping to get By Id


    /**
     * List operations
     */

    @PostMapping("/lpush")
    public void leftPush(@RequestBody @Valid PersonCreateRequest personCreateRequest) {
        personService.lpush(personCreateRequest.toPerson());
    }

    @PostMapping("/rpush")
    public void rightPush(@RequestBody @Valid PersonCreateRequest personCreateRequest) {
        personService.rpush(personCreateRequest.toPerson());
    }

    @DeleteMapping("/lpop")
    public void leftPop(@RequestParam(value = "count", required = false, defaultValue = "1") int count) {
        personService.lpop(count);
    }

    @DeleteMapping("/rpop")
    public void rightPop(@RequestParam(value = "count", required = false, defaultValue = "1") int count) {
        personService.rpop(count);
    }

    @GetMapping("/lrange")
    public List<Person> leftRange(@RequestParam(value = "count", required = false, defaultValue = "0") int start,
                                  @RequestParam(value = "count", required = false, defaultValue = "-1") int end) {
        return personService.lrange(start, end);
    }


    /**
     * Hash operations
     */

    @PostMapping("/hash")
    public void createPersonInHash(@RequestBody @Valid PersonCreateRequest personCreateRequest) {
        personService.setPersonInHash(personCreateRequest.toPerson());
    }

    @GetMapping("/hash/{personId}")
    public Person getPersonFromHash(@PathVariable("personId") String personId) {
        return personService.getPersonFromHash(personId);
    }






}
