package com.turkcell.crm.ordermanagement.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StaticIpProvider {

    public String retrieveAvailableStaticIP() {
        Random r = new Random();
        String third = String.valueOf(r.nextInt((254 - 1) + 1) + 1);
        String fourth = String.valueOf(r.nextInt((254 - 1) + 1) + 1);

        return "192.168."+third+"."+fourth;
    }

}
