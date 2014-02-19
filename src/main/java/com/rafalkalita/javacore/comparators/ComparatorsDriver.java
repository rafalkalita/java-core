package com.rafalkalita.javacore.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rafal Kalita
 */
public class ComparatorsDriver {

    public static void main(String args[]) {

        List<Person> people = new ArrayList<Person>();
        people.add(new Person("John", 33));
        people.add(new Person("Carlos", 31));
        people.add(new Person("Carmen", 26));
        people.add(new Person("David", 34));

        // default Comparable interface
        Collections.sort(people);
        System.out.println(people);

        // custom PersonAgeComparator (implements Comparator<Person> interface)
        Collections.sort(people, new PersonAgeComparator());
        System.out.println(people);
    }
}
