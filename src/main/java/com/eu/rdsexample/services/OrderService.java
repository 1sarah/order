package com.eu.rdsexample.services;

import com.eu.rdsexample.entities.Order;
import com.eu.rdsexample.helpers.Payment;
import com.eu.rdsexample.helpers.wrappers.TransactionRequest;
import com.eu.rdsexample.helpers.wrappers.TransactionResponse;
import com.eu.rdsexample.repositories.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
    Logger logger= LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository repository;


//    @Autowired
//    @Lazy
//    private RestTemplate template;
//
//    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
//    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest request)  {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        repository.save(order);
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
//        logger.info("Order-Service Request : "+new ObjectMapper().writeValueAsString(request));
        RestTemplate restTemplate = new RestTemplate();
        Payment paymentResponse = restTemplate.postForObject("http://payment-service:9094/payment/doPayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
//        logger.info("Order Service getting Response from Payment-Service : "+new ObjectMapper().writeValueAsString(response));

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
