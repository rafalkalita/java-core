package com.rafalkalita.javacore.arrays;

/**
 * User: rafalkalita
 * Date: 03/02/2014
 * Time: 12:33
 */
public class Arrays {

    static final int SIZE = 5;

    static final int ROWS = 2;
    static final int COLS = 3;

    public void declaration() {

        System.out.println("Declaration");

        int[] indexes = {0, 1, 2};
        System.out.println(indexes[2]);
        System.out.println(indexes.length);

        int[] numbersEmpty = {};
        System.out.println(numbersEmpty.length);

        int bracketsAfter[] = {3,4};
        int[] bracketsBefore = {5,6};


        int[] ages;
        ages = new int[SIZE];

        ages[0] = 35;
        System.out.println(ages[0]);

        String[] arr1, arr2;
        String arr3[], arr4[];
    }

    public void multidimensional() {

        System.out.println("\nMultidimensional");

        int grades[][];

        grades = new int[ROWS][COLS];
        grades[0][0] = 0;
        grades[0][1] = 1;
        grades[0][2] = 2;
        grades[1][0] = 3;
        grades[1][1] = 4;
        grades[1][2] = 5;

        for (int rows = 0; rows < ROWS; rows++) {
            for (int cols = 0; cols < COLS; cols++) {
                System.out.printf("%d  ", grades[rows][cols]);
            }
            System.out.println();
        }

        grades = new int[ROWS][];
        grades[0] = new int[COLS];
        grades[1] = new int[COLS];

        // ragged arrays - array that has elements of a different size
        grades[0] = new int[4];
        grades[1] = new int[2];
    }

    public void traversing() {

        System.out.println("\nTraversing");

        int ages[] = {35, 10, 43, -5, 12};
        System.out.println(ages.toString());

        for(int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }

        System.out.println();
        int i=0;
        while(i<5) {
            System.out.println(ages[i++]);
        }

        /**
         * for-each does copy elements by value
         */
        System.out.println();
        for(int number : ages) {
            number = number * number;
            System.out.println(number);
        }
        for(int j = 0; j < ages.length; j++) {
            System.out.println(ages[j]);
            ages[j] = ages[j] + 100;
        }
        for(int j = 0; j < ages.length; j++) {
            System.out.println(ages[j]);
        }

        /**
         * when you use reference in for-each loop it will modify the real object
         */
        System.out.println();
        Person[] people = {new Person("John"), new Person("Rafal")};

        for(Person person: people) {
            System.out.println(person);
            person.setName(person.getName() + " Modified");
        }

        for(int j = 0; j < people.length; j++) {
            System.out.println(people[j]);
        }
    }

    class Person {

        String name;

        public Person(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + '\'' + '}';
        }
    }
}
