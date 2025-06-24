package com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.mapper;

import com.pichincha.gaps.jayli.domain.DomainPerson;
import com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.bean.PersonRequest;
import com.pichincha.gaps.jayli.infrastructure.input.adapter.rest.models.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    DomainPerson toDomain(Person personRequest);
    Person toPerson(DomainPerson created);
}
