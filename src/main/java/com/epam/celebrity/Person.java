package com.epam.celebrity;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Person> familiar;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Person(String name) {
        this.name = name;
        familiar = new ArrayList<>();
    }

    public Person(String name, List<Person> familiarList) {
        this(name);
        addFamiliar(familiarList.toArray(new Person[]{}));
    }

    public void addFamiliar(@NonNull Person... persons) {
        for (Person p : persons) {
            addFamiliar(p);
        }

    }

    public void addFamiliar(Person person) {
        if (!familiar.contains(person)) familiar.add(person);
    }

    public void removeFamiliar(@NonNull Person person) {
        familiar.remove(person);
    }

    public boolean knows(@NonNull Person person) {
        if(this.equals(person)) throw new IllegalArgumentException("Person can't to know himself");
        return familiar.contains(person);
    }
}
