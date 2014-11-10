package com.creditcard4j.tools;

import com.creditcard4j.exception.CreditCard4JException;

/**
 * Provides tools to apply preconditions on method inputs.
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class Preconditions {
    /**
     * Asserts that a string is not empty (nor null).
     *
     * @param message the error message if the string is empty
     * @param string  the string to study
     *
     * @return the {@code string} if it was validated.
     * @throws java.lang.IllegalArgumentException if {@code string} is empty or null
     */
    public static String checkNotEmpty(String message, String string) {
        checkNotNull(message, string);
        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return string;
    }

    /**
     * Asserts that an object is not null.
     *
     * @param message the error message if the string is empty
     * @param object  the object to study
     *
     * @return the {@code object} if it was validated.
     * @throws java.lang.IllegalArgumentException if {@code object} is null
     */
    public static <T> T checkNotNull(String message, T object) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
        return object;
    }

    /**
     * Asserts that a string is longer than a requested length.
     *
     * @param message   the error message if the string is too short
     * @param string    the string to study
     * @param minLength the minimum lenght requested
     *
     * @return the {@code string} if it was long enough.
     * @throws java.lang.IllegalArgumentException               if {@code string} is null
     * @throws com.creditcard4j.exception.CreditCard4JException if {@code string} is too short
     */
    public static String checkLongerThan(String message, String string, int minLength) {
        checkNotNull(message, string);
        if (string.length() < minLength) {
            throw new CreditCard4JException(message);
        }
        return string;
    }

    /**
     * Asserts that a string only contains digits.
     *
     * @param message the error message if the string has not only digits
     * @param string  the string to study
     *
     * @return the {@code string} if it was long enough.
     * @throws java.lang.IllegalArgumentException if {@code string} is null or contains other characters than digits
     */
    public static String checkIsDigitsOnly(String message, String string) {
        checkNotNull(message, string);
        if (!string.matches("\\d*")) {
            throw new IllegalArgumentException(message);
        }
        return string;
    }
}
