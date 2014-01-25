package com.rafalkalita.javacore.types;

import java.math.BigDecimal;

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

        types.defaultValues();
        types.boxingTypes();
        types.minMaxSizeValues();
        types.otherTypes();
    }

    private void defaultValues() {

        println("\ndefaultValues");
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

    private void boxingTypes() {

        bytePrimitiveType = 1;
        shortPrimitiveType = 2;
        intPrimitiveType = 4;
        longPrimitiveType = 5l;
        floatPrimitiveType = 15.34f;
        doublePrimitiveType = 123.456;
        booleanPrimitiveType = true;
        charPrimitiveType = 'a';

        Byte byteBoxed = new Byte(bytePrimitiveType);
        Short shortBoxed = new Short(shortPrimitiveType);
        Integer intBoxed = new Integer(intPrimitiveType);
        Long longBoxed = new Long(longPrimitiveType);

        Float floatBoxed = new Float(floatPrimitiveType);
        Double doubleBoxed = new Double(doublePrimitiveType);

        Boolean boolanBoxed = new Boolean(booleanPrimitiveType);
        Character charBoxed = new Character(charPrimitiveType);

        println("\nboxingTypes");
        println(byteBoxed.toString());
        println(shortBoxed.toString());
        println(intBoxed.toString());
        println(longBoxed.toString());
        println(floatBoxed.toString());
        println(doubleBoxed.toString());
        println(boolanBoxed.toString());
        println(charBoxed.toString());

    }

    private void minMaxSizeValues() {

        println("\nminMaxSizeValues");
        println("[byte]    minValue: " + Byte.MIN_VALUE + "\t\t\t\t  maxValue: " + Byte.MAX_VALUE + " \t\t\t\t\t Size(bytes): " + Byte.SIZE/8);
        println("[short]   minValue: " + Short.MIN_VALUE + "  \t\t\t  maxValue: " + Short.MAX_VALUE + "\t\t\t\t\t Size(bytes): " + Short.SIZE/8);
        println("[int]     minValue: " + Integer.MIN_VALUE + "\t\t\t  maxValue: " + Integer.MAX_VALUE + "\t\t\t\t Size(bytes): " + Integer.SIZE/8);
        println("[long]    minValue: " + Long.MIN_VALUE + "  maxValue: " + Long.MAX_VALUE + " \t Size(bytes): " + Long.SIZE/8);
        println("[float]   minValue: " + Float.MIN_VALUE + " \t\t\t  maxValue: " + Float.MAX_VALUE + "\t\t\t Size(bytes): " + Float.SIZE/8);
        println("[double]  minValue: " + Double.MIN_VALUE + "\t\t\t  maxValue: " + Double.MAX_VALUE + "\t Size(bytes): " + Double.SIZE/8);
        println("[char]    minValue: \\u0000                maxValue: \\uffff \t\t\t\t\t Size(bytes): " + Character.SIZE/8);
        println("[boolean]    Value: true or false \t\t\t\t\t\t\t\t\t\t\t Size: --");
    }

    private void otherTypes() {

        println("\n");

        String name = "Rafa";

        BigDecimal balance = new BigDecimal("987654432.12");
        // use constructor with String
        // BigDecimal is immutable
        // BigDecimal.ROUND_HALF_EVEN introduces the least bias
        println("balance is: " + balance.toString());

        // don't use float or double to handle money
        float f = 0.1f;
        for(int i = 0; i<9; i++) {
            f += 0.1f;
        }
        println("Sum of 0.1f ten times using float equals: " + f);

        // use BigDecimal
        BigDecimal value = new BigDecimal("0.1");
        BigDecimal sum = new BigDecimal("0");
        for(int i = 0; i<10; i++) {
            sum = sum.add(value);
        }
        println("Sum of 0.1f ten times using BigDecimal equals: " + sum.toString());
    }


    private void println(String text) {
        System.out.println(text);
    }
}
