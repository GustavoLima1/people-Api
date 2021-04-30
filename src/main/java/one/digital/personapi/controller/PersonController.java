package one.digital.personapi.controller;

import one.digital.personapi.dto.MessageResponseDTO;
import one.digital.personapi.dto.request.PersonDTO;


import one.digital.personapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<PersonDTO> getAll (){
        return personService.listAll();

    }
}
