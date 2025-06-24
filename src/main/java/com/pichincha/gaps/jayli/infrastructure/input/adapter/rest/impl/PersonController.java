package com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.impl;

import com.pichincha.gaps.jayli.domain.DomainPerson;
import com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.PersonsApi;
import com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.models.ListPersons200Response;
import com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.mapper.PersonMapper;
import com.pichincha.gaps.jayli.application.input.port.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class PersonController implements PersonsApi {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @Autowired
    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @Override
    public ResponseEntity<Person> createPerson(String xGuid, String xChannel, String xApp, String xMedium, String xSession, String xKey, String xIv, Person person) {
        DomainPerson domainPerson = personMapper.toDomain(person);
        DomainPerson created = personService.createPerson(domainPerson);
        Person response = personMapper.toPerson(created);
        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<Void> deletePerson(String id, String xGuid, String xChannel, String xApp, String xMedium, String xSession, String xKey, String xIv) {
        boolean deleted = personService.deletePerson(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Person> getPersonById(String id, String xGuid, String xChannel, String xApp, String xMedium, String xSession, String xKey, String xIv) {
        DomainPerson domainPerson = personService.getPersonById(id);
        if (domainPerson == null) {
            return ResponseEntity.notFound().build();
        }
        Person person = personMapper.toPerson(domainPerson);
        return ResponseEntity.ok(person);
    }

    @Override
    public ResponseEntity<ListPersons200Response> listPersons(String xGuid, String xChannel, String xApp, String xMedium, String xSession, String xKey, String xIv, Integer page, Integer size) {
        int pageNumber = (page != null && page > 0) ? page : 1;
        int pageSize = (size != null && size > 0) ? size : 10;
        List<DomainPerson> domainPersons = personService.listPersons(pageNumber, pageSize);
        List<Person> persons = domainPersons.stream()
                .map(personMapper::toPerson)
                .toList();
        ListPersons200Response response = new ListPersons200Response()
            .content(persons)
            .totalElements(personService.listPersons().size())
            .totalPages((int) Math.ceil((double) personService.listPersons().size() / pageSize))
            .page(pageNumber)
            .size(pageSize);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Person> updatePerson(String id, String xGuid, String xChannel, String xApp, String xMedium, String xSession, String xKey, String xIv, Person person) {
        DomainPerson domainPerson = personMapper.toDomain(person);
        DomainPerson updated = personService.updatePerson(id, domainPerson);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        Person response = personMapper.toPerson(updated);
        return ResponseEntity.ok(response);
    }

}
