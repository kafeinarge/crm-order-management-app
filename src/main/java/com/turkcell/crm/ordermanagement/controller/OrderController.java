package com.turkcell.crm.ordermanagement.controller;

import com.turkcell.crm.ordermanagement.dto.OrderDTO;
import com.turkcell.crm.ordermanagement.dto.Response;
import com.turkcell.crm.ordermanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.turkcell.crm.ordermanagement.util.OrderConstants.ORDER_FAILED;
import static com.turkcell.crm.ordermanagement.util.OrderConstants.ORDER_SUCCESS;


@RestController
@Slf4j
public class OrderController {

    final
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Response createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            orderService.save(orderDTO);
            return Response.builder()
                    .httpStatus(HttpStatus.OK.value())
                    .data(ORDER_SUCCESS)
                    .build();
        } catch (Exception e) {
            log.error("Order cannot be created. Id -> " + orderDTO.getId());
            return Response.builder()
                    .httpStatus(HttpStatus.SERVICE_UNAVAILABLE.value())
                    .data(ORDER_FAILED)
                    .build();
        }
    }

}
