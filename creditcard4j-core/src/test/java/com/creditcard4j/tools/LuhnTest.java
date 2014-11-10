package com.creditcard4j.tools;

import com.creditcard4j.AbstractTest;
import com.creditcard4j.exception.CreditCard4JException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnTest extends AbstractTest {
    @Test
    public void isValid_with_unprocessable_number_fails() {
        // GIVEN
        String number = "12345678a";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        Luhn.isValid(number);
    }

    @Test
    public void isValid_with_too_short_number_fails() {
        // GIVEN
        String number = "1";

        // THEN
        this.expectedEx.expect(CreditCard4JException.class);

        // WHEN
        Luhn.isValid(number);
    }

    @Test
    public void isValid_with_invalid_number_returns_false() {
        // GIVEN
        String number = "123456789";

        // WHEN
        boolean valid = Luhn.isValid(number);

        // THEN
        assertFalse(valid);
    }

    @Test
    public void isValid_with_valid_number_returns_true() {
        // GIVEN
        String number = "4242424242424242";

        // WHEN
        boolean valid = Luhn.isValid(number);

        // THEN
        assertTrue(valid);
    }
}
