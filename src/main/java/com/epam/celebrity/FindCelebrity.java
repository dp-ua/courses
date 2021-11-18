package com.epam.celebrity;

import lombok.NonNull;

import java.util.List;
import java.util.Stack;

public class FindCelebrity {

    public Person findCelebrity(@NonNull List<Person> persons) {
        if (persons.size() == 0) throw new IllegalArgumentException("Persons list cant be null");
        if (persons.size() == 1) return persons.get(0);

        final Stack<Person> stackPersons = new Stack<>();
        stackPersons.addAll(persons);
        while (stackPersons.size() != 1) {
            Person p1 = stackPersons.pop();
            Person p2 = stackPersons.pop();
            stackPersons.push(p1.knows(p2) ? p2 : p1);
        }
        final Person celeb = stackPersons.peek();
        return knowsSomeoneElse(celeb, persons) ? null : celeb;
    }


    private boolean knowsSomeoneElse(Person person, List<Person> persons) {
        for (Person p : persons) {
            if (!p.equals(person) && person.knows(p)) return true;
        }
        return false;
    }
}
