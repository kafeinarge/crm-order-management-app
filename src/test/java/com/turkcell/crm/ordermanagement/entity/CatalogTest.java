package com.turkcell.crm.ordermanagement.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class CatalogTest {
    private Catalog catalog;

    @Before
    public void setUp() {
        catalog = new Catalog();
        catalog.setCode("TRK01");
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertNotNull(catalog.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(catalog.toString());
    }

    @Test
    public void equalsTest() {
        Catalog documentToCompare = creatCatalog();
        Order nullRequest = null;
        Object nullObject = null;
        Assertions.assertTrue(documentToCompare.equals(catalog) && catalog.equals(documentToCompare));
        assertFalse(catalog.equals(nullRequest));
        assertFalse(catalog.equals(nullObject));
    }

    private Catalog creatCatalog() {
        Catalog catalog = new Catalog();
        catalog.setCode("TRK01");
        return catalog;
    }
}
