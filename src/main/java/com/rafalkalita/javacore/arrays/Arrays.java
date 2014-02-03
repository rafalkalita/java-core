package com.rafalkalita.javacore.arrays;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println();
        for(int j = 0; j < ages.length; j++) {
            System.out.println(ages[j]);
            ages[j] = ages[j] + 100;
        }
        System.out.println();
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

    public void comparingArrays() {

        System.out.println("\nComparingArrays");
        int arr1[];
        int arr2[];
        arr1 = new int[5];
        arr2 = new int[5];

        for(int i = 0; i < 5; i++) {
            arr1[i] = 0;
            arr2[i] = 0;
        }

        // Element-by-element comparison
        // Using indexes is an error prone and tedious approach.
        boolean areEqual = true;
        for (int i = 0; i < 5; i++) {
            if(arr1[i]!= arr2[i]) {
                areEqual = false;
            }
        }
        System.out.println(areEqual); // Displays true

        // Using the equality operator
        System.out.println(arr1 == arr2);  // Displays false

        // Using the equals method
        System.out.println(arr1.equals(arr2));  // Displays false

        // Using the deepEquals method
        System.out.println(java.util.Arrays.equals(arr1,arr2));

        System.out.println();
        // The deepEquals method requires an array of objects
        Person[] people1 = {new Person("John"), new Person("Rafal")};
        Person[] people2 = {new Person("John"), new Person("Rafal")};

        System.out.println(people1 == people2);
        System.out.println(people1.equals(people2));
        System.out.println(java.util.Arrays.equals(people1, people2));
        System.out.println(java.util.Arrays.deepEquals(people1, people2));

        System.out.println();
        // Arrays.equals doesn't work for array of int. deepEquals does.
        int grades1[][] = new int[ROWS][];
        int grades2[][] = new int[ROWS][];

        grades(grades1);
        grades(grades2);

        System.out.println(grades1 == grades2);
        System.out.println(grades1.equals(grades2));
        System.out.println(java.util.Arrays.equals(grades1, grades2));
        System.out.println(java.util.Arrays.deepEquals(grades1, grades2));
    }

    public void copyingArrays() {

        int numbers[] = {1,2,3,4,5};
        int numbersCopy[] = new int[5];

        // shallow copy is when only references are copied
        // deep copy is when a new copy of the whole object is created

        println("Simple element-by-element copy - Tedious but can implement either a shallow or deep copy");
        for(int i=0; i<5; i++) {
            numbersCopy[i] = numbers[i]; // shallow copy
        }
        printIntArray(numbersCopy);

        for(int i=0; i<5; i++) {
            numbersCopy[i] = new Integer(numbers[i]); // deep copy
        }
        printIntArray(numbersCopy);


        println("Using the System.arraycopy method - Performs a shallow copy");
        // System.arrayCopy method(copies references only)
        // public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
        java.util.Arrays.fill(numbersCopy, 0);
        System.arraycopy(numbers, 0, numbersCopy, 0, 5);
        printIntArray(numbersCopy);

        java.util.Arrays.fill(numbersCopy, 0);
        System.arraycopy(numbers, 0, numbersCopy, 2, 3);
        printIntArray(numbersCopy);

        java.util.Arrays.fill(numbersCopy, 0);
        System.arraycopy(numbers, 0, numbersCopy, 3, 2);
        printIntArray(numbersCopy);


        println("Using the Arrays.copyOf method - Performs a deep copy of the entire array");
        int arr[];
        // copyOf can trim the array
        arr = java.util.Arrays.copyOf(numbers, 3);
        printIntArray(arr);

        // if newLength is greater then array length the remaining elements will be set to zeros
        arr = java.util.Arrays.copyOf(numbers, 10);
        printIntArray(arr);


        println("Using the Arrays.copyOfRange method - Performs a deep copy of part of an array");
        int arr2[];
        // copyOfRange copies 5-3 elements starting from index 3
        arr2 = java.util.Arrays.copyOfRange(numbers, 3, 5);
        printIntArray(arr2);

        // if we specify more elements to copy, new array will be padded with zeros
        arr2 = java.util.Arrays.copyOfRange(numbers, 3, 8);
        printIntArray(arr2);

        println("Using the clone method - Performs a shallow copy");
        arr2 = numbers.clone();
        printIntArray(arr2);
    }

    public void passingArraysToMethods() {

        Person people[] = {new Person("Mike"), new Person("Maria")};

        for(Person person: people) {
            System.out.println(person);
        }

        // array references are copied by value
        // the way to create a new array is to return a new instance
        Person[] result = addNumberOfLetters(people);

        for(Person person: people) {
            System.out.println(person);
        }

        for(Person person: result) {
            System.out.println(person);
        }
    }

    public void otherArrayMethods() {

        println("\nOtherArrayMethods");

        int arr1[] = new int[5];
        ArrayList list = new ArrayList();

        list.add("item 1");
        list.add("item 2");

        Object arr2[] = {"item 3", new Integer(5), list};
        String arr3[] = {"Pine", "Oak", "Maple", "Walnut"};

        java.util.Arrays.fill(arr1,5); // fills all elements with a given value

        List<String> woodColors = java.util.Arrays.asList(arr3);
        System.out.println(woodColors);
        System.out.println(java.util.Arrays.toString(arr1));
        System.out.println(java.util.Arrays.deepToString(arr2));

        List list2 = java.util.Arrays.asList(arr3);
        list2.set(0, "Birch");
        System.out.println(java.util.Arrays.toString(arr3));
    }

    private Person[] addNumberOfLetters(Person[] people) {
        Person peopleNew[] = new Person[people.length];

        for(Person person: people) {
            person = new Person(person.getName() + person.getName().length());
            System.out.println(person);
        }

        for(int i=0;i<people.length;i++) {
            peopleNew[i] = new Person(people[i].getName() + people[i].getName().length());
        }
        return peopleNew;
    }

    private void printIntArray(int[] a) {
        for(int i=0; i<a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }

    private void grades(int[][] grades) {

        grades[0] = new int[COLS];
        grades[1] = new int[COLS];
        grades[0][0] = 0;
        grades[0][1] = 1;
        grades[0][2] = 2;
        grades[1][0] = 3;
        grades[1][1] = 4;
        grades[1][2] = 5;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            if (name != null ? !name.equals(person.name) : person.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    private void println(String s) {
        System.out.println(s);
    }
}
