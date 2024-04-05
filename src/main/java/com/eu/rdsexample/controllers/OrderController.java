package com.eu.rdsexample.controllers;

import com.eu.rdsexample.entities.Order;
import com.eu.rdsexample.helpers.wrappers.TransactionRequest;
import com.eu.rdsexample.helpers.wrappers.TransactionResponse;
import com.eu.rdsexample.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;


    @PostMapping("/placeOrder")
    public TransactionResponse placeOrder(@RequestBody TransactionRequest request) {
        return  service.saveOrder(request);
    }
}
