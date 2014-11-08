package com.creditcard4j.tools;

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
}
