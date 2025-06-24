package com.pichincha.gaps.jayli.domain;

public class DomainPerson {

    private String id;

    private String firstName;

    private String lastName;

    private Integer age;

    public DomainPerson(String id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

}
