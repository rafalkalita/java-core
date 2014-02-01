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

    public void defaultValues() {

        println("\ndefaultValues");
        println("Default byte: " + bytePrimitiveType);

        println("Default short: " + shortPrimitiveType);
        println("Default int: " + intPrimitiveType);
        println("Default long: " + longPrimitiveType);

        println("Default float: " + floatPrimitiveType);
        println("Default double: " + doublePrimitiveType);

        println("Default boolean: " + booleanPrimitiveType);
        println("Default char: " + charPrimitiveType);

        if (new Character(charPrimitiveType).compareTo("\u0000".charAt(0)) == 0) {
            println("charPrimitiveType default value is \\u0000");
        }
    }

    public void boxingTypes() {

        bytePrimitiveType = 1;
        shortPrimitiveType = 2;
        intPrimitiveType = 4;
        longPrimitiveType = 5l;
        floatPrimitiveType = 15.34f;
        doublePrimitiveType = 123.456;
        booleanPrimitiveType = true;
        charPrimitiveType = 'a';

        Byte byteBoxed = bytePrimitiveType;
        Short shortBoxed = shortPrimitiveType;
        Integer intBoxed = intPrimitiveType;
        Long longBoxed = longPrimitiveType;

        Float floatBoxed = floatPrimitiveType;
        Double doubleBoxed = doublePrimitiveType;

        Boolean boolanBoxed = booleanPrimitiveType;
        Character charBoxed = charPrimitiveType;

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

    public void minMaxSizeValues() {

        println("\nminMaxSizeValues");
        println("[byte]    minValue: " + Byte.MIN_VALUE + "\t\t\t\t  maxValue: " + Byte.MAX_VALUE + " \t\t\t\t\t Size(bytes): " + Byte.SIZE / 8);
        println("[short]   minValue: " + Short.MIN_VALUE + "  \t\t\t  maxValue: " + Short.MAX_VALUE + "\t\t\t\t\t Size(bytes): " + Short.SIZE / 8);
        println("[int]     minValue: " + Integer.MIN_VALUE + "\t\t\t  maxValue: " + Integer.MAX_VALUE + "\t\t\t\t Size(bytes): " + Integer.SIZE / 8);
        println("[long]    minValue: " + Long.MIN_VALUE + "  maxValue: " + Long.MAX_VALUE + " \t Size(bytes): " + Long.SIZE / 8);
        println("[float]   minValue: " + Float.MIN_VALUE + " \t\t\t  maxValue: " + Float.MAX_VALUE + "\t\t\t Size(bytes): " + Float.SIZE / 8);
        println("[double]  minValue: " + Double.MIN_VALUE + "\t\t\t  maxValue: " + Double.MAX_VALUE + "\t Size(bytes): " + Double.SIZE / 8);
        println("[char]    minValue: \\u0000                maxValue: \\uffff \t\t\t\t\t Size(bytes): " + Character.SIZE / 8);
        println("[boolean]    Value: true or false \t\t\t\t\t\t\t\t\t\t\t Size: --");
    }

    public void otherTypes() {

        println("\notherTypes");

        String name = "Rafa";

        BigDecimal balance = new BigDecimal("987654432.12");
        // use constructor with String
        // BigDecimal is immutable
        // BigDecimal.ROUND_HALF_EVEN introduces the least bias
        println("balance is: " + balance.toString());

        // don't use float or double to handle money
        float f = 0.1f;
        for (int i = 0; i < 9; i++) {
            f += 0.1f;
        }
        println("Sum of 0.1f ten times using float equals: " + f);

        // use BigDecimal
        BigDecimal value = new BigDecimal("0.1");
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < 10; i++) {
            sum = sum.add(value);
        }
        println("Sum of 0.1f ten times using BigDecimal equals: " + sum.toString());
    }

    public void numericLiterals() {

        println("\nnumericLiterals");

        printInt(25, "25");
        printInt(-235, "-235");
        printInt(073, "073");
        printInt(0x3F, "0x3F");
        printInt(012, "012");

        printFloat(23.5f, "23.5f");
        printFloat(23.5F, "23.5F");

        printDouble(23.5, "23.5");
        printDouble(3.14, "3.14");
        printDouble(35.05E13, "35.05E13");
        printDouble(35.05E2, "35.05E2");
        printDouble(10e6, "10e6");

        printLong(10L, "10L");
        printLong(0x10, "0x10");
        printLong(0x10L, "0x10L");

        println("\nnumericLiterals added in Java 7:");
        printInt(11_22_33, "11_22_33");
        printLong(111_22_3333L, "111_22_3333L");
        printInt(0b0110_00_1, "0b0110_00_1");

        printFloat(3.14_15F, "3.14_15F");
        /**
         * consecutive underscores are treated as one and also ignored by the compiler
         * Underscores cannot be placed:
         * - At the beginning or end of a number
         * - Adjacent to a decimal point
         * - Prior to the D, F, or L suffix
         */

        // using a mask:
        byte value = (byte) 0b0111_1010;
        byte result = (byte) (value & 0b0000_1111);
        printInt(result, "0b0111_1010 & 0b0000_1111");
    }

    public void characterLiterals() {

        println("\ncharacterLiterals");
        println("\b backspace");
        println("\f form feed");
        println("\n new line");
        println("\r carriage return");
        println("\t horizontal tab");
        println("\\ backslash");
        println("\' single quote");
        println("\" double quote");
    }

    public void constants() {
        final double PI = 3.14159;
        final int NUMSHIPS = 120;
        final float RATEOFRETURN = 0.125F;

        println("\nConstants:");
        println(Double.toString(PI));
        println(Integer.toString(NUMSHIPS));
        println(Float.toString(RATEOFRETURN));
    }

    public void casting() {
        int i;
        float f = 1.123F;
        double d = 2.345;

        println("\nCasting:");
        println("Cast a float 1.123F to an int: " + Integer.toString((int)f));
        println("Cast a double 2.345 to an int: " + Integer.toString((int)d));
        println("Cast a double 2.345 to a float: " + Float.toString((float)d));
    }

    public void floatingPointValues() {

        println("\nFloatingPointValues");
        println(String.valueOf(Math.sqrt(-2.3))); // NaN
        println(String.valueOf(3.14/0)); // Infinity
        println(String.valueOf(-3.14/0)); // -Infinity

        println("\n");

        float num1 = 0.0f;
        println(num1 / 0.0f); // NaN
        println(Math.sqrt(-4)); // NaN
        println(Double.NaN + Double.NaN); // NaN
        println(Float.NaN + 2); // NaN
        println((int) Double.NaN); // 0

        println("\n");

        println(Float.NEGATIVE_INFINITY); // -Infinity
        println(Double.NEGATIVE_INFINITY); // -Infinity
        println(Float.POSITIVE_INFINITY); // Infinity
        println(Double.POSITIVE_INFINITY); // Infinity
        println(Float.POSITIVE_INFINITY + 2); // Infinity
        println(1.0 / 0.0); // Infinity
        println((1.0 / 0.0) - (1.0 / 0.0)); // NaN
        println(23.0f / 0.0f); // Infinity
        println((int) (1.0 / 0.0)); // 2147483647
        println(Float.NEGATIVE_INFINITY == Double.NEGATIVE_INFINITY); // true

        println("\n");

        println(-1.0f / Float.POSITIVE_INFINITY); // -0.0
        println(1.0f / Float.NEGATIVE_INFINITY); // -0.0
        println(1.0f / Float.POSITIVE_INFINITY); // 0.0

        println(0 == -0); // true

        println("\n");
        double num2 = 1.2f;
        double num3 = 0.2f;
        println((num2 / num3) == 6); // false

        float epsilon = 0.000001f;
        if (Math.abs((num2 / num3) - 6) < epsilon) {
            println("They are effectively equal");
        } else {
            println("They are not equal");
        }

        // order
        println(new Float(Float.NEGATIVE_INFINITY).compareTo(-2.0f)); // -1
        println((new Float(-2.0)).compareTo(-0.0f)); // -1
        println((new Float(-0.0)).compareTo(0.0f)); // -1
        println((new Float(0.0)).compareTo(2.0f)); // -1
        println((new Float(2.0)).compareTo(Float.POSITIVE_INFINITY)); // -1
        println((new Float(Float.POSITIVE_INFINITY)).compareTo(Float.NaN)); // -1

        calculateFloatingPointValueUsingIEEE();
    }

    // use strictfp on a class interface or a method to make calculations abide IEEE standard
    private strictfp void calculateFloatingPointValueUsingIEEE() {
        float sum = 0.0f;
        for(int i = 0; i < 10; i++) {
            sum += 0.1f;
        }
        println(sum);
    }

    private void printInt(int value, String numericLiteral) {
        println("decimal equivalent of " + numericLiteral + " is: " + Integer.toString(value));
    }

    private void printDouble(double value, String numericLiteral) {
        println("decimal equivalent of " + numericLiteral + " is: " + Double.toString(value));
    }

    private void printFloat(float value, String numericLiteral) {
        println("decimal equivalent of " + numericLiteral + " is: " + Float.toString(value));
    }

    private void printLong(long value, String numericLiteral) {
        println("decimal equivalent of " + numericLiteral + " is: " + Long.toString(value));
    }

    private void println(String text) {
        System.out.println(text);
    }

    private void println(double value) {
        System.out.println(String.valueOf(value));
    }

    private void println(float value) {
        System.out.println(String.valueOf(value));
    }

    private void println(int value) {
        System.out.println(String.valueOf(value));
    }

    private void println(boolean value) {
        System.out.println(String.valueOf(value));
    }
}
