package com.java.study.kafka.avro;

import java.util.Random;

public class CustomerGenerator {

    public static Customer getNext() {
        Random random = new Random();
        int randomValue = random.nextInt(100) + 1;

        Customer customer = Customer.newBuilder()
                .setCustomerID(randomValue)
                .setCustomerName("user" + randomValue)
                .build();
        return customer;
    }
}
