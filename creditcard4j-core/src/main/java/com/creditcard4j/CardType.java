package com.creditcard4j;

public enum CardType {
    AMERICAN_EXPRESS("34", "37"),
    DINERS_CLUB("300", "301", "302", "303", "304", "305", "36", "38"),
    DISCOVER("6011", "65"),
    JCB("2131", "1800", "35"),
    MASTERCARD("51", "52", "53", "54", "55"),
    UNKNOWN,
    VISA("4");

    private final String[] prefixes;

    private CardType(String... prefixes) {
        this.prefixes = prefixes;
    }

    public String[] getPrefixes() {
        return this.prefixes;
    }
}
