package com.creditcard4j;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnTest extends CreditCard4JTest {
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
        this.expectedEx.expect(IllegalArgumentException.class);

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
        // TODO
//        String number = "4242424242424242";
        String number = "4000056655665556";

        // WHEN
        boolean valid = Luhn.isValid(number);

        // THEN
        assertTrue(valid);
    }
}
