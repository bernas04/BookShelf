package com.bookshelf.demo.DataTransferObject;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryGeneric implements Serializable{
    private String clientName;

    private AddressGeneric address;

    private long startTime;


    public DeliveryGeneric(String clientName, AddressGeneric address, long startTime) {
        this.clientName = clientName;
        this.address = address;
        this.startTime = startTime;
    }

    public DeliveryGeneric() {
    }

}
