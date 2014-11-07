package com.creditcard4j.tools;

import com.creditcard4j.CreditCard4J;

import static com.creditcard4j.tools.Preconditions.checkNotNull;

public class CardNumberCleaner {
    public static String clean(String cardNumber) {
        checkNotNull("Invalid card number", cardNumber);
        if (!isInputAcceptable(cardNumber)) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return cardNumber.replaceAll("[^\\d]", "");
    }

    protected static boolean isInputAcceptable(String cardNumber) {
        String regex = "[0-9";
        if (CreditCard4J.ALLOW_SPACINGS_IN_CARD_NUMBERS) {
            for (String spacing : CreditCard4J.CARD_NUMBERS_SPACING_CHARACTERS) {
                regex += spacing;
            }
        }
        regex += "]*";
        return cardNumber.matches(regex);
    }
}
