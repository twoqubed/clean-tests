package com.twoqubed.testing.product;

import java.math.BigDecimal;
import java.util.Date;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Maker;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import static com.natpryce.makeiteasy.MakeItEasy.*;
import static com.natpryce.makeiteasy.Property.*;
import static com.twoqubed.testing.product.CategoryMaker.Category;

public class ProductMaker {

    public static Property<Product, String> productNumber = newProperty();
    public static Property<Product, String> name = newProperty();
    public static Property<Product, String> description = newProperty();
    public static Property<Product, Date> inactiveDate = newProperty();
    public static Property<Product, String> inactiveReason = newProperty();

    public static Instantiator<Product> Product = new Instantiator<Product>() {
        @Override
        public Product instantiate(PropertyLookup<Product> lookup) {
            return new Product(
                lookup.valueOf(productNumber, "123456"),
                lookup.valueOf(name, "Kindle"),
                lookup.valueOf(description, "7 Kindle eReader"),
                make(a(Category)),
                new BigDecimal(2.50),
                null,
                null,
                lookup.valueOf(inactiveDate, (Date) null),
                lookup.valueOf(inactiveReason, null));
        }
    };

    public static Maker<Product> anInactiveProduct = a(Product,
        with(inactiveDate, new Date()),
        with(inactiveReason, "Obsolete"));
}
