package com.api.receipt_processor.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class Receipt {
    public String retailer;
    public String id;

    public LocalDate purchaseDate;
    public LocalTime purchaseTime;

    public List<Item> items;

    public double total;

    public Receipt() {

    }

    public Receipt(String retailer, LocalDate purchaseDate, LocalTime purchaseTime, List<Item> items, double total) {
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
        return id;
    }

    public LocalDate getPurchase_Date() {
        return purchaseDate;
    }

    public void setPurchase_Date(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalTime getPurchase_Time() {
        return purchaseTime;
    }

    public void setPurchase_Time(LocalTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return Double.valueOf(total);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return " \"retailer\": " + retailer + ", " +
                "\n\"id\": " + id + ", " +
                "\n\"purchaseDate\": " + purchaseDate + ", " +
                "\n\"purchaseTime\": " + purchaseTime + ", " +
                "\n\"items\":" + items + ", " +
                "\n\"total\": " + total + ", ";
    }
}
