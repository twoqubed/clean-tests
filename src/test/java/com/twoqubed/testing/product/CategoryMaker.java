package com.twoqubed.testing.product;

import java.math.BigDecimal;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import static com.natpryce.makeiteasy.Property.newProperty;

public class CategoryMaker {

    public static Property<Category, String> categoryId = newProperty();
    public static Property<Category, String> name = newProperty();

    public static Instantiator<Category> Category = new Instantiator<Category>() {
        @Override
        public Category instantiate(PropertyLookup<Category> lookup) {
            return new Category(
                lookup.valueOf(categoryId, "123456"),
                lookup.valueOf(name, "Electronics"));
        }
    };
}
