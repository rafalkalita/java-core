package com.rafalkalita.javacore.types;

/**
 * User: rafalkalita
 * Date: 25/01/2014
 * Time: 00:35
 */
public class Types {

    private byte bytePrimitiveType;
    private short shortPrimitiveType;
    private int intPrimitiveType;
    private long longPrimitiveType;

    private float floatPrimitiveType;
    private double doublePrimitiveType;

    private boolean booleanPrimitiveType;
    private char charPrimitiveType;

    public static void main(String [] args) {

        Types types = new Types();

        types.printDefaultValues();
    }

    private void printDefaultValues() {

        println("Default byte: " + bytePrimitiveType);

        println("Default short: " + shortPrimitiveType);
        println("Default int: " + intPrimitiveType);
        println("Default long: " + longPrimitiveType);

        println("Default float: " + floatPrimitiveType);
        println("Default double: " + doublePrimitiveType);

        println("Default boolean: " + booleanPrimitiveType);
        println("Default char: " + charPrimitiveType);

        if( new Character(charPrimitiveType).compareTo("\u0000".charAt(0)) == 0){
            println("charPrimitiveType default value is \\u0000");
        }
    }

    private void println(String text) {
        System.out.println(text);
    }
}
