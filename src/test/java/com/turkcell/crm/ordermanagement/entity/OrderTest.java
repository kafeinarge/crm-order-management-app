package com.turkcell.crm.ordermanagement.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
        order.setId("1");
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertNotNull(order.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(order.toString());
    }

    @Test
    public void equalsTest() {
        Order documentToCompare = createOrder();
        Order nullRequest = null;
        Object nullObject = null;
        Assertions.assertTrue(documentToCompare.equals(order) && order.equals(documentToCompare));
        assertFalse(order.equals(nullRequest));
        assertFalse(order.equals(nullObject));
    }

    private Order createOrder() {
        Order order = new Order();
        order.setId("1");
        return order;
    }

}


