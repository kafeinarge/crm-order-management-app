package com.turkcell.crm.ordermanagement.dto;

import com.turkcell.crm.ordermanagement.dto.base.BaseDTO;
import com.turkcell.crm.ordermanagement.entity.Catalog;
import com.turkcell.crm.ordermanagement.entity.Customer;
import lombok.Data;

@Data
public class OrderDTO extends BaseDTO {


    private Customer customer;

    private Catalog catalog;


}