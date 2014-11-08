package com.creditcard4j;

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
     */
    public static boolean isValid(String number) {
        // TODO optimize this method!
        checkLongerThan("The number must have at least 2 characters.", number, 2);
        checkIsDigitsOnly("Only digits are allowed", number);
        int length = number.length();
        int checkDigit = Integer.valueOf(number.substring(length - 1, length));
        char[] chars = number.substring(0, length - 1).toCharArray();
        int[] original = charsToInts(chars);
        int[] doubled = doubleEveryOtherDigit(original);
        int[] simplified = simplify(doubled);
        int sum = sum(simplified);
        int finalNumber = sum + checkDigit;
        return finalNumber % 10 == 0;
    }

    private static int[] charsToInts(char[] chars) {
        int len = chars.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.valueOf(String.valueOf(chars[len - i - 1]));
        }
        return ints;
    }

    private static int[] doubleEveryOtherDigit(int[] original) {
        int len = original.length;
        int[] doubled = new int[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                doubled[i] = original[i];
            } else {
                doubled[i] = original[i] * 2;
            }
        }
        return doubled;
    }

    private static int[] simplify(int[] doubled) {
        int len = doubled.length;
        int[] simplified = new int[len];
        for (int i = 0; i < len; i++) {
            simplified[i] = simplify(doubled[i]);
        }
        return simplified;
    }

    private static int simplify(int original) {
        if (original < 10) {
            return original;
        } else {
            return original - 9;
        }
    }

    private static int sum(int[] simplified) {
        int sum = 0;
        for (int num : simplified) {
            sum += num;
        }
        return sum;
    }
}
