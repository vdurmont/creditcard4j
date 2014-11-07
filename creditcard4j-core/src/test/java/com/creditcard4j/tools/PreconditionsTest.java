package com.creditcard4j.tools;

import com.creditcard4j.CreditCard4JTest;
import org.junit.Test;

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
}