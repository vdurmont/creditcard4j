package com.creditcard4j;

import android.text.Editable;
import android.text.TextWatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class CreditCardEditTextWatcherTest {
    @Test
    public void enter_a_digit_returns_the_text() {
        // GIVEN
        CreditCardEditTextWatcher cc = new CreditCardEditTextWatcher();
        String original = "";
        String input = "1";

        // WHEN
        String result = simulateTextInput(cc, original, input);

        // THEN
        assertEquals(input, result);
    }

    @Test
    public void enter_4_digits_returns_the_text_with_a_space() {
        // GIVEN
        CreditCardEditTextWatcher cc = new CreditCardEditTextWatcher();

        // WHEN
        String result = "";
        for (int i = 1; i <= 4; i++) {
            result = simulateTextInput(cc, result, String.valueOf(i));
        }

        // THEN
        assertEquals("1234 ", result);
    }

    @Test
    public void enter_16_digits_returns_the_text_with_a_spaces_each_4_digits() {
        // GIVEN
        CreditCardEditTextWatcher cc = new CreditCardEditTextWatcher();

        // WHEN
        String result = "";
        for (int i = 1; i <= 16; i++) {
            result = simulateTextInput(cc, result, String.valueOf(i % 10));
        }

        // THEN
        assertEquals("1234 5678 9012 3456 ", result);
    }

    @Test
    public void test_all_the_world() {
        fail("Missing tests.");
    }

    private static String simulateTextInput(TextWatcher tw, String original, String input) {
        // TODO review all the int parameters
        tw.beforeTextChanged(original, 0, original.length(), input.length());

        String newText = original + input;
        tw.onTextChanged(newText, 1, newText.length() - 1, 1);

        Editable editable = new MyEditable(newText);
        tw.afterTextChanged(editable);
        return editable.toString();
    }
}
