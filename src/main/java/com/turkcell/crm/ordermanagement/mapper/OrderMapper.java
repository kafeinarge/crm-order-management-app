package com.turkcell.crm.ordermanagement.mapper;

import com.turkcell.crm.ordermanagement.dto.OrderDTO;
import com.turkcell.crm.ordermanagement.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderDTO> {
}
