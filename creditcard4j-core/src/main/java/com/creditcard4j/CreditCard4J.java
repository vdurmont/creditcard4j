package com.creditcard4j;

/**
 * Main class for the CreditCard4j project.
 * It contains all the configuration for the library.
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class CreditCard4J {
    /**
     * The list of the allowed spacing characters that will be ignored when validating a card number.
     */
    public static String[] ALLOWED_CARD_NUMBERS_SPACING_CHARACTERS;

    static {
        resetConfig();
    }


    /**
     * Resets the default config of {@link com.creditcard4j.CreditCard4J}
     */
    public static void resetConfig() {
        ALLOWED_CARD_NUMBERS_SPACING_CHARACTERS = new String[]{" ", "-"};
    }
}
