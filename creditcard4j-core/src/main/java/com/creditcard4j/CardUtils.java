package com.creditcard4j;

import com.creditcard4j.tools.CardNumberCleaner;

import static com.creditcard4j.tools.Preconditions.checkNotNull;

public class CardUtils {
    private static final int MAX_CARD_NUMBER_LENGTH = 7;

    public static CardType getType(String cardNumber) {
        checkNotNull("Invalid card number", cardNumber);
        String number = CardNumberCleaner.clean(cardNumber);
        if (number.length() < MAX_CARD_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Invalid card number: a card number should have at least 7 digits.");
        }

        for (CardType type : CardType.values()) {
            for (String prefix : type.getPrefixes()) {
                if (cardNumber.startsWith(prefix)) {
                    return type;
                }
            }
        }

        return CardType.UNKNOWN;
    }
}
