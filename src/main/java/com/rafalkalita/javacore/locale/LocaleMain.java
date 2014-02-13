package com.rafalkalita.javacore.locale;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Rafal Kalita
 */
public class LocaleMain {

    public void currency() {

        Locale locale;

        locale = Locale.US;
        System.out.println(locale);

        locale = Locale.GERMANY;
        System.out.println(locale);

        printCurrency(12.34, Locale.GERMANY);
        printCurrency(56.78, Locale.UK);
        printCurrency(90.12, Locale.US);

    }

    public void date() {

        printDate(Locale.US);
        printDate(Locale.UK);
        printDate(Locale.GERMANY);
    }

    private void printCurrency(double value, Locale locale) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println(currencyFormatter.format(value));
    }

    private void printDate(Locale locale) {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(dateFormatter.format(new Date()));
    }
}
