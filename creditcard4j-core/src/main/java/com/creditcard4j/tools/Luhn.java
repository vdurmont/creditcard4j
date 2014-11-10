package com.creditcard4j.tools;

import com.creditcard4j.exception.CreditCard4JException;

import static com.creditcard4j.tools.Preconditions.checkIsDigitsOnly;
import static com.creditcard4j.tools.Preconditions.checkLongerThan;

/**
 * Implementation of the Luhn Algorithm.
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class Luhn {
    /**
     * Checks the given number against the Luhn algorithm.
     *
     * @param number the number to study
     *
     * @return true if the number is valid
     * @throws java.lang.IllegalArgumentException               if the card number is malformed
     * @throws com.creditcard4j.exception.CreditCard4JException is the card number is less than 2 digits long
     */
    public static boolean isValid(String number) {
        checkLongerThan("The number must have at least 2 characters.", number, 2);
        checkIsDigitsOnly("Only digits are allowed", number);
        int length = number.length();

        // We will study all the digits but the last
        char[] chars = number.substring(0, length - 1).toCharArray();
        // Init the sum with the check digit
        int sum = Character.getNumericValue(number.charAt(length - 1));
        for (int i = 0; i < length - 1; i++) {
            // Get the digit
            int value = Character.getNumericValue(chars[length - i - 2]);
            // For each other digit multiply the value by 2
            value *= (i % 2 == 1) ? 1 : 2;
            // If the result has 2 digits, we replace it by the sum of the 2 digits
            // Incrementing the sum by the result.
            sum += value < 10 ? value : value - 9;
        }
        // If the sum % 10 == 0, the number is valid
        return sum % 10 == 0;
    }

    /**
     * Checks the validity of the card number against the Luhn algorithm.
     *
     * @param number the card number
     *
     * @return the validated number
     * @throws java.lang.IllegalArgumentException               if the number is malformed
     * @throws com.creditcard4j.exception.CreditCard4JException if the number is invalid
     */
    public static String checkValidity(String number) {
        if (!isValid(number)) {
            throw new CreditCard4JException("Invalid card number (Luhn Algorithm failed)");
        }
        return number;
    }
}
