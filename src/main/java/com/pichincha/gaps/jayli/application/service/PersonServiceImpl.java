package com.pichincha.gaps.jayli.application.service;

import com.pichincha.gaps.jayli.application.input.port.PersonService;
import com.pichincha.gaps.jayli.application.output.port.PersonRepository;
import com.pichincha.gaps.jayli.domain.DomainPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public DomainPerson createPerson(DomainPerson person) {
        return personRepository.createPerson(person);
    }

    @Override
    public List<DomainPerson> listPersons() {
        return personRepository.listPersons();
    }

    @Override
    public List<DomainPerson> listPersons(int page, int size) {
          return personRepository.listPersons(  page, size);
    }

    @Override
    public DomainPerson getPersonById(String id) {
        return personRepository.getPersonById(id);
    }

    @Override
    public DomainPerson updatePerson(String id, DomainPerson person) {
        return personRepository.updatePerson(id, person);
    }

    @Override
    public boolean deletePerson(String id) {
        return personRepository.deletePerson(id);
    }

}
