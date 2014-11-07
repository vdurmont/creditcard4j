package com.creditcard4j.tools;

import com.creditcard4j.CreditCard4J;
import com.creditcard4j.CreditCard4JTest;
import com.creditcard4j.tools.CardNumberCleaner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardNumberCleanerTest extends CreditCard4JTest {
    @Test
    public void clean_with_a_null_number_fails() {
        // GIVEN

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        CardNumberCleaner.clean(null);
    }

    @Test
    public void clean_only_returns_the_digits() {
        // GIVEN
        String number = "12 34-567 ";

        // WHEN
        String cleaned = CardNumberCleaner.clean(number);

        // THEN
        assertEquals("1234567", cleaned);
    }

    @Test
    public void isInputAcceptable_if_spacing_is_allowed_accepts_the_spacing() {
        // GIVEN
        CreditCard4J.ALLOW_SPACINGS_IN_CARD_NUMBERS = true;
        String number = "12 34-567";

        // WHEN
        boolean accept = CardNumberCleaner.isInputAcceptable(number);

        // THEN
        assertTrue(accept);
    }

    @Test
    public void isInputAcceptable_if_spacing_is_not_allowed_rejects_the_spacing() {
        // GIVEN
        CreditCard4J.ALLOW_SPACINGS_IN_CARD_NUMBERS = false;
        String number = "12 34-567";

        // WHEN
        boolean accept = CardNumberCleaner.isInputAcceptable(number);

        // THEN
        assertFalse(accept);
    }

    @Test
    public void isInputAcceptable_rejects_any_other_character() {
        // GIVEN
        String[] numbers = {"1a234567", "1A234567", "1+234567", "1%234567", "1\n234567", "1\t234567"};

        for (String number : numbers) {
            // WHEN
            boolean accept = CardNumberCleaner.isInputAcceptable(number);

            // THEN
            assertFalse(accept);
        }
    }
}