package com.turkcell.crm.ordermanagement.controller;

import com.turkcell.crm.ordermanagement.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.turkcell.crm.ordermanagement.OrderConstants.ORDER_FAILED;
import static com.turkcell.crm.ordermanagement.OrderConstants.ORDER_SUCCESS;


@RestController
@Slf4j
public class OrderController {


    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            //TODO
            return ResponseEntity.ok(ORDER_SUCCESS);
        } catch (Exception e) {
            log.error("Order cannot be created. Id -> " + orderDTO.getId());
            return ResponseEntity.of(Optional.of(ORDER_FAILED));
        }
    }

}
