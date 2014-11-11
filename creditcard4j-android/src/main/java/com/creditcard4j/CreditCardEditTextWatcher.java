package com.creditcard4j;

import android.text.Editable;
import android.text.TextWatcher;
import com.creditcard4j.tools.CardNumberCleaner;

/**
 * Implementation of {@link android.text.TextWatcher} that improves the card number readability
 * by inserting spacing characters as the user enters it.
 *
 * Example: "4242424242424242" becomes "4242 4242 4242 4242"
 */
public class CreditCardEditTextWatcher implements TextWatcher {
    private final char spacingCharacter;

    /**
     * Builds a CreditCardEditTextWatcher with the default spacing character (' ').
     */
    public CreditCardEditTextWatcher() {
        this(' ');
    }

    /**
     * Builds a CreditCardEditTextWatcher with a chose spacing character.
     *
     * @param spacingCharacter the spacing character to insert each 4 digits
     */
    public CreditCardEditTextWatcher(char spacingCharacter) {
        this.spacingCharacter = spacingCharacter;
    }

    @Override public void beforeTextChanged(CharSequence sequence, int start, int count, int after) {
    }

    @Override public void onTextChanged(CharSequence sequence, int start, int before, int count) {

    }

    @Override public void afterTextChanged(Editable editable) {
        String number = editable.toString();
        if (number.length() > 0) {
            String digitsOnly = CardNumberCleaner.clean(number);
            if (digitsOnly.length() % 4 == 0) {
                editable.append(this.spacingCharacter);
            }
        }
    }
}
