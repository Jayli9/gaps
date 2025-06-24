package com.pichincha.gaps.jayli.infrastructure.output.repository;

import com.pichincha.gaps.jayli.application.output.port.PersonRepository;
import com.pichincha.gaps.jayli.domain.DomainPerson;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final List<DomainPerson> persons = new ArrayList<>(Arrays.asList(
            new DomainPerson("1", "Juan", "Pérez", 30),
            new DomainPerson("2", "Ana", "García", 25)
    ));

    @Override
    public DomainPerson createPerson(DomainPerson person) {
        persons.add(person);
        return person;
    }

    @Override
    public List<DomainPerson> listPersons() {
        return new ArrayList<>(persons);
    }

    @Override
    public List<DomainPerson> listPersons(int page, int size) {
        int pageNumber = (page > 0) ? page : 1;
        int pageSize = (size > 0) ? size : 10;
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, persons.size());
        return (fromIndex < persons.size()) ? new ArrayList<>(persons.subList(fromIndex, toIndex)) : List.of();
    }

    @Override
    public DomainPerson getPersonById(String id) {
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public DomainPerson updatePerson(String id, DomainPerson person) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId().equals(id)) {
                DomainPerson updated = new DomainPerson(id, person.getFirstName(), person.getLastName(), person.getAge());
                persons.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    @Override
    public boolean deletePerson(String id) {
        return persons.removeIf(p -> p.getId().equals(id));
    }
}
