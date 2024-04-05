package com.eu.rdsexample.helpers.wrappers;

import com.eu.rdsexample.entities.Order;
import com.eu.rdsexample.helpers.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;
}
