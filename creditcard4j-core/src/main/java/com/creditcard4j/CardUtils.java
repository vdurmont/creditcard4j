package com.creditcard4j;

import com.creditcard4j.tools.CardNumberCleaner;

import static com.creditcard4j.tools.Preconditions.checkNotNull;

/**
 * Utility class that provides methods to manage credit cards.
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class CardUtils {
    private static final int MAX_CARD_NUMBER_LENGTH = 7;

    /**
     * Returns the {@link CardBrand} from a card number.
     * If the number is valid but the brand cannot be determined, we will return CardType.UNKNOWN
     *
     * @param cardNumber the card number
     *
     * @return the brand
     */
    public static CardBrand getBrand(String cardNumber) {
        checkNotNull("Invalid card number", cardNumber);
        String number = CardNumberCleaner.clean(cardNumber);
        if (number.length() < MAX_CARD_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Invalid card number: a card number should have at least 7 digits.");
        }

        for (CardBrand type : CardBrand.values()) {
            for (String prefix : type.getPrefixes()) {
                if (cardNumber.startsWith(prefix)) {
                    return type;
                }
            }
        }

        return CardBrand.UNKNOWN;
    }
}
