package com.turkcell.crm.ordermanagement.entity;

import com.turkcell.crm.ordermanagement.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends BaseEntity {

    private Customer customer;

    private Catalog catalog;

    private String staticIP;




}
