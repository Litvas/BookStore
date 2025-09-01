package org.litvas.bookstore.domain;

import java.math.BigDecimal;

public enum BookType {
    NEW_RELEASE(new BigDecimal("0.00"), new BigDecimal("0.00")),
    REGULAR(new BigDecimal("0.00"), new BigDecimal("0.10")),
    OLD_EDITION(new BigDecimal("0.20"), new BigDecimal("0.05"));

    private final BigDecimal discount;
    private final BigDecimal additionalDiscount;

    BookType(BigDecimal discount, BigDecimal additionalDiscount) {
        this.discount = discount;
        this.additionalDiscount = additionalDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getAdditionalDiscount() {
        return additionalDiscount;
    }
}
