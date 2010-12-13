package com.twoqubed.testing.product;

import com.natpryce.makeiteasy.Maker;
import org.junit.Before;
import org.junit.Test;

import static com.natpryce.makeiteasy.MakeItEasy.*;
import static com.twoqubed.testing.product.ProductMaker.*;
import static org.junit.Assert.*;

public class ProductRenderTest {
    private ProductRenderer renderer;

    @Before
    public void setUp() {
        renderer = new ProductRenderer();
    }

    @Test
    public void shouldRenderProductNameAndDescriptionOnFirstLine() {
        Maker<Product> aProduct = a(Product,
            with(name, "foo"));

        Product bar = make(aProduct.but(with(description, "bar")));
        assertEquals("bar", bar.getDescription());


        Product baz = make(aProduct.but(with(description, "baz")));
        assertEquals("baz", baz.getDescription());
    }

    @Test
    public void shouldTruncateDescriptionIfLongerThan20Characters() {
        fail();
    }

    @Test
    public void shouldRenderPriceOnSecondLine() {
        fail();
    }

    @Test
    public void shouldRenderInactiveInformationOnThirdLineIfExists() {
        fail();
    }

}
