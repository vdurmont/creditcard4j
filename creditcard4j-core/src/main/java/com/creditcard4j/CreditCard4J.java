package com.creditcard4j;

import com.creditcard4j.exception.CreditCard4JException;
import com.creditcard4j.tools.CardNumberCleaner;
import com.creditcard4j.tools.Luhn;

import static com.creditcard4j.tools.Preconditions.checkLongerThan;
import static com.creditcard4j.tools.Preconditions.checkNotNull;

/**
 * Main class for the CreditCard4j project.
 * It contains all the configuration for the library and provides the tools to manage credit cards.
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class CreditCard4J {
    private static final int MIN_CARD_NUMBER_LENGTH = 7;

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

    /**
     * Returns the {@link CardBrand} from a card number.
     * If the number is valid but the brand cannot be determined, we will return CardType.UNKNOWN
     *
     * @param cardNumber the card number
     *
     * @return the brand
     * @throws java.lang.IllegalArgumentException if the card number is malformed
     */
    public static CardBrand getBrand(String cardNumber) {
        checkNotNull("Invalid card number", cardNumber);
        String number = CardNumberCleaner.clean(cardNumber);

        for (CardBrand type : CardBrand.values()) {
            for (String prefix : type.getPrefixes()) {
                if (number.startsWith(prefix)) {
                    return type;
                }
            }
        }

        return CardBrand.UNKNOWN;
    }

    /**
     * Validates and cleans the card number.
     *
     * @param cardNumber the card number to validate
     *
     * @return the cleaned and validated card number
     * @throws java.lang.IllegalArgumentException               if the card number is malformed
     * @throws com.creditcard4j.exception.CreditCard4JException if the number is invalid
     */
    public static String validateCardNumber(String cardNumber) {
        String cleanedNumber = CardNumberCleaner.clean(cardNumber);
        checkLongerThan("Invalid card number: a card number should have at least 7 digits.", cleanedNumber, MIN_CARD_NUMBER_LENGTH);
        return Luhn.checkValidity(cleanedNumber);
    }

    /**
     * Determines if the card number is valid
     *
     * @param cardNumber the card number to validate
     *
     * @return true if the card number is valid
     * @throws java.lang.IllegalArgumentException if the card number is malformed
     */
    public static boolean isValidCardNumber(String cardNumber) {
        try {
            validateCardNumber(cardNumber);
            return true;
        } catch (CreditCard4JException e) {
            return false;
        }
    }
}
