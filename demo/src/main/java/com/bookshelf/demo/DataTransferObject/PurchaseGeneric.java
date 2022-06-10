package com.bookshelf.demo.DataTransferObject;

import java.util.List;


import lombok.Data;

@Data
public class PurchaseGeneric {

    private long personID;
    
    private long dateStart;

    private long addressID;

    private List<Long> productsID;

    public PurchaseGeneric(Long addressID, List<Long> productsID) {
        this.addressID = addressID;
        this.productsID = productsID;
    }

    public PurchaseGeneric(){ }


    public long getPersonID() {
        return this.personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public long getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(long dateStart) {
        this.dateStart = dateStart;
    }

    public long getAddressID() {
        return this.addressID;
    }

    public void setAddressID(long addressID) {
        this.addressID = addressID;
    }

    public List<Long> getProductsID() {
        return this.productsID;
    }

    public void setProductsID(List<Long> productsID) {
        this.productsID = productsID;
    }
    
}
