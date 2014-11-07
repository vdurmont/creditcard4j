package com.creditcard4j;

public class CreditCard4J {
    public static String[] CARD_NUMBERS_SPACING_CHARACTERS;
    public static boolean ALLOW_SPACINGS_IN_CARD_NUMBERS;

    static {
        resetConfig();
    }

    public static void resetConfig() {
        CARD_NUMBERS_SPACING_CHARACTERS = new String[]{" ", "-"};
        ALLOW_SPACINGS_IN_CARD_NUMBERS = true;
    }
}
