package one.digital.personapi.controller;

import one.digital.personapi.dto.MessageResponseDTO;
import one.digital.personapi.entity.Person;

import one.digital.personapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonService personService;

     @Autowired
     public PersonController(PersonService personService){
        this.personService = personService;
     }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
