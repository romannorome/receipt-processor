package com.api.receipt_processor.Model;

public class Item {
    public String shortDescription;
    public String price;

    public Item() {

    }

    public Item(String shortDescription, String price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public String getDescription() {
        return shortDescription;
    }

    public void setDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public double getPrice() {
        return Double.parseDouble(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n\t\"shortDescription\": " + shortDescription + ", " + "\n\t\"price\": " + price + "\n";
    }
}
