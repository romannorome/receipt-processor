package com.api.receipt_processor.Model;

public class Item {
    public String description;
    public double price;

    public Item() {

    }

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n \t \"description\": " + description + ", " + "\n \t \"price\": " + price + "\n";
    }
}
