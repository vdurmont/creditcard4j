package com.creditcard4j.tools;

public class Preconditions {
    public static void checkNotEmpty(String message, String string) {
        checkNotNull(message, string);
        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkNotNull(String message, Object object) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
