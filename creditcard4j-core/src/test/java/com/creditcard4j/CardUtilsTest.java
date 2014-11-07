package com.creditcard4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardUtilsTest extends CreditCard4JTest {
    @Test
    public void getBrand_with_a_null_number_fails() {
        // GIVEN

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        CardUtils.getBrand(null);
    }

    @Test
    public void getBrand_with_a_number_with_less_than_7_digits_fails() {
        // GIVEN
        String number = "123456";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        CardUtils.getBrand(number);
    }

    @Test
    public void getBrand_with_a_number_with_less_than_7_digits_but_more_than_7_characters_fails() {
        // GIVEN
        String number = "1234 56";

        // THEN
        this.expectedEx.expect(IllegalArgumentException.class);

        // WHEN
        CardUtils.getBrand(number);
    }

    @Test
    public void getBrand_with_the_visa_prefix_returns_VISA() {
        // GIVEN
        String number = "4123456";

        // WHEN
        CardBrand brand = CardUtils.getBrand(number);

        // THEN
        assertEquals(CardBrand.VISA, brand);
    }

    @Test
    public void getBrand_with_the_mastercard_prefix_returns_MASTERCARD() {
        // GIVEN
        String[] numbers = {"51123456", "52123456", "53123456", "54123456", "55123456"};

        for (String number : numbers) {
            // WHEN
            CardBrand brand = CardUtils.getBrand(number);

            // THEN
            assertEquals(CardBrand.MASTERCARD, brand);
        }
    }

    @Test
    public void getBrand_with_the_american_express_prefix_returns_AMERICAN_EXPRESS() {
        // GIVEN
        String[] numbers = {"34123456", "37123456"};

        for (String number : numbers) {
            // WHEN
            CardBrand brand = CardUtils.getBrand(number);

            // THEN
            assertEquals(CardBrand.AMERICAN_EXPRESS, brand);
        }
    }

    @Test
    public void getBrand_with_the_diners_club_prefix_returns_DINERS_CLUB() {
        // GIVEN
        String[] numbers = {"300123456", "301123456", "302123456", "303123456", "304123456", "305123456", "36123456", "38123456"};

        for (String number : numbers) {
            // WHEN
            CardBrand brand = CardUtils.getBrand(number);

            // THEN
            assertEquals(CardBrand.DINERS_CLUB, brand);
        }
    }

    @Test
    public void getBrand_with_the_discover_prefix_returns_DISCOVER() {
        // GIVEN
        String[] numbers = {"6011123456", "65123456"};

        for (String number : numbers) {
            // WHEN
            CardBrand brand = CardUtils.getBrand(number);

            // THEN
            assertEquals(CardBrand.DISCOVER, brand);
        }
    }

    @Test
    public void getBrand_with_the_jcb_prefix_returns_JCB() {
        // GIVEN
        String[] numbers = {"2131123456", "1800123456", "35123456"};

        for (String number : numbers) {
            // WHEN
            CardBrand brand = CardUtils.getBrand(number);

            // THEN
            assertEquals(CardBrand.JCB, brand);
        }
    }

    @Test
    public void getBrand_with_another_prefix_returns_UNKNOWN() {
        // GIVEN
        String number = "23452456";

        // WHEN
        CardBrand brand = CardUtils.getBrand(number);

        // THEN
        assertEquals(CardBrand.UNKNOWN, brand);
    }
}
