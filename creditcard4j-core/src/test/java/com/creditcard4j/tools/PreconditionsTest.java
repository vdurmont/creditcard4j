package com.creditcard4j.tools;

import com.creditcard4j.CreditCard4JTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreconditionsTest extends CreditCard4JTest {
    @Test
    public void checkNotEmpty_with_a_null_string_fails() {
        // GIVEN
        String message = "my message";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);
        this.expectedEx.expectMessage(message);

        // WHEN
        Preconditions.checkNotEmpty(message, null);
    }

    @Test
    public void checkNotEmpty_with_an_empty_string_fails() {
        // GIVEN
        String message = "my message";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);
        this.expectedEx.expectMessage(message);

        // WHEN
        Preconditions.checkNotEmpty(message, "");
    }

    @Test
    public void checkNotEmpty_with_a_string_is_ok() {
        // GIVEN
        String message = "my message";

        // WHEN
        Preconditions.checkNotEmpty(message, "my string");

        // THEN
        // Nothing happens.
    }

    @Test
    public void checkNotNull_with_a_null_object_fails() {
        // GIVEN
        String message = "my message";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);
        this.expectedEx.expectMessage(message);

        // WHEN
        Preconditions.checkNotNull(message, null);
    }

    @Test
    public void checkNotNull_with_an_object_is_ok() {
        // GIVEN
        String message = "my message";

        // WHEN
        Preconditions.checkNotNull(message, new Object());

        // THEN
        // Nothing happens.
    }

    @Test
    public void checkLongerThan_with_null_string_fails() {
        // GIVEN
        String message = "my message";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        Preconditions.checkLongerThan(message, null, 2);
    }

    @Test
    public void checkLongerThan_with_too_short_string_fails() {
        // GIVEN
        String message = "my message";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        Preconditions.checkLongerThan(message, "a", 2);
    }

    @Test
    public void checkLongerThan_with_long_enough_string_returns_the_string() {
        // GIVEN
        String message = "my message";
        String string = "string";

        // WHEN
        String result = Preconditions.checkLongerThan(message, string, 2);

        // THEN
        assertEquals(string, result);
    }

    @Test
    public void checkIsDigitsOnly_with_null_string_fails() {
        // GIVEN
        String message = "my message";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        Preconditions.checkIsDigitsOnly(message, null);
    }

    @Test
    public void checkIsDigitsOnly_with_letters_fails() {
        // GIVEN
        String message = "my message";
        String string = "0123456789a";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        Preconditions.checkIsDigitsOnly(message, string);
    }

    @Test
    public void checkIsDigitsOnly_with_only_digits_returns_the_string() {
        // GIVEN
        String message = "my message";
        String string = "0123456789";

        // WHEN
        String result = Preconditions.checkIsDigitsOnly(message, string);

        // THEN
        assertEquals(string, result);
    }
}