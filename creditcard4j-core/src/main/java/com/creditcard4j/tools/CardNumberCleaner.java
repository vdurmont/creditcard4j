package com.creditcard4j.tools;

import com.creditcard4j.CreditCard4J;

import static com.creditcard4j.tools.Preconditions.checkNotNull;

/**
 * Provides methods to clean and transform a card number.
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class CardNumberCleaner {
    /**
     * Cleans a card number by removing all the non-digits characters.
     *
     * @param cardNumber the card number
     *
     * @return the cleaned card number
     * @throws java.lang.IllegalArgumentException if the number if malformed
     */
    public static String clean(String cardNumber) {
        checkNotNull("Invalid card number", cardNumber);
        if (!isInputAcceptable(cardNumber)) {
            throw new IllegalArgumentException("Invalid card number (unauthorized characters)");
        }
        return cardNumber.replaceAll("[^\\d]", "");
    }

    /**
     * Defines if a card number input is acceptable.
     * It checks if the number only contains digits and the authorized spacing characters.
     *
     * @param cardNumber the input card number
     *
     * @return true if the input is acceptable
     */
    protected static boolean isInputAcceptable(String cardNumber) {
        String regex = "[0-9";
        for (String spacing : CreditCard4J.ALLOWED_CARD_NUMBERS_SPACING_CHARACTERS) {
            regex += spacing;
        }
        regex += "]*";
        return cardNumber.matches(regex);
    }
}
