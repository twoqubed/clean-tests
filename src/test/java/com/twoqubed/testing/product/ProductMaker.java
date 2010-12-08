package com.twoqubed.testing.product;

import java.math.BigDecimal;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import static com.natpryce.makeiteasy.Property.newProperty;

public class ProductMaker {

    public static Property<Product, String> productNumber = newProperty();
    public static Property<Product, String> name = newProperty();
    public static Property<Product, String> description = newProperty();

    public static Instantiator<Product> Product = new Instantiator<Product>() {
        @Override
        public Product instantiate(PropertyLookup<Product> lookup) {
            return new Product(
                lookup.valueOf(productNumber, "123456"),
                lookup.valueOf(name, "Kindle"),
                lookup.valueOf(description, "7 Kindle eReader"),
                null,
                new BigDecimal(2.50),
                null,
                null,
                null,
                null);
        }
    };

}
