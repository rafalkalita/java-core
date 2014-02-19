package com.rafalkalita.javacore.comparators;

import java.util.Comparator;

/**
 * @author Rafal Kalita
 */
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
