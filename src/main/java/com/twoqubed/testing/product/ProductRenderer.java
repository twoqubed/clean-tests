package com.twoqubed.testing.product;

public class ProductRenderer {

    public String[] render(Product product) {
        return new String[] { String.format("%s - %s", product.getName(), product.getDescription())};
    }
}
