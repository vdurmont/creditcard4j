package com.creditcard4j;

public enum CardBrand {
    AMERICAN_EXPRESS("34", "37"),
    DINERS_CLUB("300", "301", "302", "303", "304", "305", "36", "38"),
    DISCOVER("6011", "65"),
    JCB("2131", "1800", "35"),
    MASTERCARD("51", "52", "53", "54", "55"),
    UNKNOWN,
    VISA("4");

    private final String[] prefixes;

    private CardBrand(String... prefixes) {
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
}
