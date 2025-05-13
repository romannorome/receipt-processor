package com.api.receipt_processor.Model;

import java.util.List;
import java.util.UUID;

public class Receipt {
    public String retailer;
    public String id;

    public String purchaseDate;
    public String purchaseTime;

    public List<Item> items;

    public String total;

    public Receipt() {

    }

    public Receipt(String retailer, String purchaseDate, String purchaseTime, List<Item> items, String total) {
        this.retailer = retailer;
        this.id = UUID.randomUUID().toString();
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
        this.total = total;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getId() {
        return " \"id\": " + id;
    }

    public String getPurchase_Date() {
        return purchaseDate;
    }

    public void setPurchase_Date(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchase_Time() {
        return purchaseTime;
    }

    public void setPurchase_Time(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return " \"retailer\": " + retailer + ", " +
                "\n \"id\": " + id + ", " +
                "\n \"purchaseDate\": " + purchaseDate + ", " +
                "\n \"purchaseTime\": " + purchaseTime + ", " +
                "\n \"items\":" + items + ", " +
                "\n \"total\": " + total + ", ";
    }
}
