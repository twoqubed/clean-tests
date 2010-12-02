package com.twoqbued.testing;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private final String productNumer;
    private final String name;
    private final String description;
    private final Category category;
    private final BigDecimal retailPrice;
    private final BigDecimal discountPrice;
    private final String discountReason;
    private final Date inactiveDate;
    private final String inactiveReason;

    public Product(String productNumer, String name, String description, Category category, BigDecimal retailPrice,
        BigDecimal discountPrice, String discountReason, Date inactiveDate, String inactiveReason) {
        this.productNumer = productNumer;
        this.name = name;
        this.description = description;
        this.category = category;
        this.retailPrice = retailPrice;
        this.discountPrice = discountPrice;
        this.discountReason = discountReason;
        this.inactiveDate = inactiveDate;
        this.inactiveReason = inactiveReason;
    }

    public String getProductNumer() {
        return productNumer;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public String getInactiveReason() {
        return inactiveReason;
    }
}
