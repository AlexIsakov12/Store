package com.alexisakov.storeproject.webapp.controllers;

import com.alexisakov.storeproject.service.OrderPageDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    private final OrderPageDtoService orderPageDtoService;

    public OrderRestController(OrderPageDtoService orderPageDtoService) {
        this.orderPageDtoService = orderPageDtoService;
    }

    @GetMapping("/getOrderPage")
    public ResponseEntity<?> getOrderItems(@RequestParam("orders") List<Long> orderNumbers) {
        return new ResponseEntity<>(orderPageDtoService.getOrderPageByOrderIds(orderNumbers), HttpStatus.OK);
    }

}
