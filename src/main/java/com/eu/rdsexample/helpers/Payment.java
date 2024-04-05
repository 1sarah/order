package com.eu.rdsexample.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private UUID orderId;
    private double amount;
}
