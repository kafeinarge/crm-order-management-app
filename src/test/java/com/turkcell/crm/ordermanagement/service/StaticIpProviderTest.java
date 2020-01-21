package com.turkcell.crm.ordermanagement.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class StaticIpProviderTest {

    @InjectMocks
    StaticIpProvider staticIpProvider;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAvailableStaticIP() {
        String staticIp = staticIpProvider.retrieveAvailableStaticIP();

        Assert.assertNotNull(staticIp);
    }
}