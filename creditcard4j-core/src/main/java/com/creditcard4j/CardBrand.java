package com.creditcard4j;

/**
 * Enumeration describing the various credit card brands.
 *
 * Information retrieved on https://en.wikipedia.org/wiki/Bank_card_number
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public enum CardBrand {
    AMERICAN_EXPRESS(15, "34", "37"),
    DINERS_CLUB(16, "300", "301", "302", "303", "304", "305", "36", "38"),
    DISCOVER(16, "6011", "65"),
    JCB(16, "2131", "1800", "35"),
    MASTERCARD(16, "51", "52", "53", "54", "55"),
    UNKNOWN(19),
    VISA(16, "4");

    private final int maxLength;
    private final String[] prefixes;

    private CardBrand(int maxLength, String... prefixes) {
        this.maxLength = maxLength;
        this.prefixes = prefixes;
    }

    /**
     * The list of the known prefixes for a card from this brand.
     * Since the data is not centralized in a public database, the list can be incomplete.
     *
     * @return the prefixes
     */
    public String[] getPrefixes() {
        return this.prefixes;
    }

    /**
     * Returns the maximum length of the card number according to the brand.
     *
     * @return the maximum length
     */
    public int getMaxLength() {
        return this.maxLength;
    }
}
