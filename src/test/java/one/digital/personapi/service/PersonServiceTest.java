package one.digital.personapi.service;





import one.digital.personapi.dto.MessageResponseDTO;
import one.digital.personapi.dto.request.PersonDTO;
import one.digital.personapi.entity.Person;

import static org.mockito.Mockito.any;
import one.digital.personapi.repository.PersonRepository;
import one.digital.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;


    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = ExpectedSucessResponse(expectedSavedPerson.getId());
        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, sucessMessage);
    }

    private MessageResponseDTO ExpectedSucessResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + id)
                .build();
    }
}

