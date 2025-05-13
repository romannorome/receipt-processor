package com.api.receipt_processor.Model;

import java.util.List;
import java.util.UUID;

public class Receipt {
    public String retailer;
    public UUID id;

    public String purchase_date;
    public String purchase_time;

    public List<Item> items;

    public double total;

    public Receipt() {

    }

    public Receipt(String retailer, String purchase_date, String purchase_time, List<Item> items, double total) {
        this.retailer = retailer;
        this.id = UUID.randomUUID();
        this.purchase_date = purchase_date;
        this.purchase_time = purchase_time;
        this.items = items;
        this.total = total;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public UUID getId() {
        return id;
    }

    public String getPurchase_Date() {
        return purchase_date;
    }

    public void setPurchase_Date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPurchase_Time() {
        return purchase_time;
    }

    public void setPurchase_Time(String purchase_time) {
        this.purchase_time = purchase_time;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return " \"retailer\": " + retailer + ", " +
                "\n \"id\": " + id + ", " +
                "\n \"purchaseDate\": " + purchase_date + ", " +
                "\n \"purchaseTime\": " + purchase_time + ", " +
                "\n \"items\":" + items + ", " +
                "\n \"total\": " + total + ", ";
    }
}
