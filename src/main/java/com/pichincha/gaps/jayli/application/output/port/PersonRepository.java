package com.pichincha.gaps.jayli.application.output.port;

import com.pichincha.gaps.jayli.domain.DomainPerson;
import java.util.List;

public interface PersonRepository {

    DomainPerson createPerson(DomainPerson person);
    List<DomainPerson> listPersons();
    List<DomainPerson> listPersons(int page, int size);

    /**
     * Busca una persona por su id.
     */
    DomainPerson getPersonById(String id);

    /**
     * Actualiza una persona por su id.
     */
    DomainPerson updatePerson(String id, DomainPerson person);

    /**
     * Elimina una persona por su id.
     */
    boolean deletePerson(String id);
}
