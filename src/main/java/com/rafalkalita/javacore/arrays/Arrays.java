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
    }
}
