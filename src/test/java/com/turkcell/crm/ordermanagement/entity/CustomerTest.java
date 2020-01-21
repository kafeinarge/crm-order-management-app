package com.turkcell.crm.ordermanagement.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setTckn("13647285617");
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertNotNull(customer.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(customer.toString());
    }

    @Test
    public void equalsTest() {
        Customer documentToCompare = createCustomer();
        Customer nullRequest = null;
        Object nullObject = null;
        Assertions.assertTrue(documentToCompare.equals(customer) && customer.equals(documentToCompare));
        assertFalse(customer.equals(nullRequest));
        assertFalse(customer.equals(nullObject));
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setTckn("13647285617");
        return customer;
    }

}
