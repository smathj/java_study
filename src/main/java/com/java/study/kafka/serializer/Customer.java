package com.java.study.kafka.serializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int customerID;
    private String customerName;

    public int getID() {
        return this.customerID;
    }

    public String getName() {
        return this.customerName;
    }

}
