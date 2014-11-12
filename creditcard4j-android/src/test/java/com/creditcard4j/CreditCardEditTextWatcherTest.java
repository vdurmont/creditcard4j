package com.creditcard4j;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.EditText;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class CreditCardEditTextWatcherTest {
    @Before
    public void setUp() {
        CreditCard4J.resetConfig();
    }

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
    public void enter_16_digits_with_a_specified_spacing_character_returns_the_text_with_the_spacing_character_each_4_digits() {
        // GIVEN
        CreditCard4J.ALLOWED_CARD_NUMBERS_SPACING_CHARACTERS = new String[]{"&"};
        CreditCardEditTextWatcher cc = new CreditCardEditTextWatcher('&');

        // WHEN
        String result = "";
        for (int i = 1; i <= 16; i++) {
            result = simulateTextInput(cc, result, String.valueOf(i % 10));
        }

        // THEN
        assertEquals("1234&5678&9012&3456&", result);
    }

    @Test
    public void enter_the_maxLength_digits_for_the_card_brand_focuses_on_the_next_input() {
        // GIVEN
        EditText editText = new EditText(Robolectric.application);
        CreditCardEditTextWatcher cc = new CreditCardEditTextWatcher(editText);
        String number = "4242424242424242"; // VISA
        int maxLenght = CreditCard4J.getBrand(number).getMaxLength();

        // WHEN
        simulateTextInput(cc, number.substring(0, maxLenght - 1), String.valueOf(number.charAt(maxLenght - 1)));

        // THEN
        assertTrue(editText.hasFocus());
    }

    private static String simulateTextInput(TextWatcher tw, String original, String input) {
        // TODO review all the int parameters
        tw.beforeTextChanged(original, 0, original.length(), input.length());

        String newText = original + input;
        tw.onTextChanged(newText, 1, newText.length() - 1, 1);


        Editable editable = new SpannableStringBuilder(newText);
        tw.afterTextChanged(editable);
        return editable.toString();
    }
}
