package com.bookshelf.demo.DataTransferObject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddressGeneric implements Serializable{
    private long addressId;

    @NonNull
    private String road;

    @NonNull
    private String city;

    @NonNull
    private String country;

    @NonNull
    private String zipcode;

    @JsonIgnore
    private long client_id;


    public AddressGeneric() {
    }

    public AddressGeneric(String road, String city, String country, String zipcode) {
        this.road = road;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }


    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getRoad() {
        return this.road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public long getClient_id() {
        return this.client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }


}
