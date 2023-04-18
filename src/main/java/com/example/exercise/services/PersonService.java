package com.example.exercise.services;

import com.example.exercise.data.models.Person;
import com.example.exercise.data.PersonNotFoundException;
import com.example.exercise.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    public List<Person> getAllPersons() {
        Iterable<Person> iterable = personRepository.findAll();
        List<Person> persons = new ArrayList<>();
        iterable.forEach(persons::add);
        return persons;
    }

}
