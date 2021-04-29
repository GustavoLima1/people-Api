package one.digital.personapi.controller;

import one.digital.personapi.dto.MessageResponseDTO;
import one.digital.personapi.dto.request.PersonDTO;


import one.digital.personapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }
}
