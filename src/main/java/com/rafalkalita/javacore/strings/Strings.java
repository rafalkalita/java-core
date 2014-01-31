package com.rafalkalita.javacore.strings;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * User: rafalkalita
 * Date: 31/01/2014
 * Time: 12:14
 */
public class Strings {

    public void comparison() {

        String s1 = "Test";
        String s2 = "test";
        String s3 = new String(s1);

        String concatenated = "My " + s2;

        System.out.println("\nComparison");

        if(s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }

        if(s1 == s3) {
            System.out.println("s1 == s3");
        } else {
            System.out.println("s1 != s3");
        }

        if(s1.equalsIgnoreCase(s2)) {
            System.out.println("s1 equalsIgnoreCase s2");
        }

        if(s1.equals(s3)) {
            System.out.println("s1 equals s3");
        }

        System.out.println("\"Test\".compareTo(\"test\"): " + s1.compareTo(s2));
        System.out.println("\"Test\".compareToIgnoreCase(\"test\"): " + s1.compareToIgnoreCase(s2));

    }

    public void searching() {

        String s1 = " This is a test string ";
        String s2 = "is a";
        String s3 = "tony";

        System.out.println("\nSearching");

        if(s1.startsWith(" This")) {
            System.out.println("s1 startsWith(\" This\")");
        }

        if(!s1.startsWith("This")) {
            System.out.println("s1 does not startsWith(\"This\")");
        }

        if(s1.endsWith("ing")) {
            System.out.println("s1 endsWith(\"ing\")");
        }

        System.out.println("[" + s1.trim() + "]");

        System.out.println("\"test\".charAt(2)  " + "test".charAt(2));
        System.out.println("international".substring(0,5));
        System.out.println("international".substring(5,"international".length()));
        System.out.println("international".substring(5));
        System.out.println("international".substring(5, 11));

        System.out.println("international".indexOf('n'));
        System.out.println("international".indexOf("nation"));
        System.out.println("international".indexOf("nonexisting"));
        System.out.println("international".indexOf('t', 4));
        System.out.println("international".lastIndexOf('t'));

        System.out.println("Grey cat is lazy".replace("Grey", "Black").replace("lazy", "smart"));
    }

    public void numbers() {

        String s1 = String.valueOf(123);
        String s2 = String.valueOf(3.1415);

        int valueInt = Integer.valueOf("123");
        double valueInt1 = Integer.valueOf("123").doubleValue();
        double valueDouble = Double.valueOf("3.1415");

        System.out.println("\nNumbers");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(valueInt);
        System.out.println(valueInt1);
        System.out.println(valueDouble);


        int num1 = Integer.parseInt("560");
        double num2 = Double.parseDouble("2.06784");
        System.out.println(num1);
        System.out.println(num2);
    }

    public void encoding() {

        String rafal = "Rafa\u0142";
        String rafal1 = "Rafal";

        System.out.println("\nEncoding");

        System.out.println("\"Rafa\u0142\".equals(\"Rafal\") is " + rafal.equals(rafal1));
        System.out.println(rafal);
        System.out.println(rafal1);
        System.out.println("toUpperCase: " + rafal.toUpperCase());
        System.out.println("toLowerCase: " + rafal.toLowerCase());
        System.out.println("length: " + rafal.length());

        System.out.println("bytes.length: " + howManyBytes(rafal));
        System.out.println("bytes.length: " + howManyBytes(rafal1));

    }

    private int howManyBytes(String string) {

        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer uCharBuffer = CharBuffer.wrap(string);

        try {
            ByteBuffer bbuf = encoder.encode(uCharBuffer);

            byte[] bytes = bbuf.array();

            CharBuffer cbuf = decoder.decode(bbuf);

            String s = cbuf.toString();
            System.out.println("String is: " + s);

            return bytes.length;
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
