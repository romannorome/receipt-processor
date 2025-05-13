package com.api.receipt_processor.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.receipt_processor.Model.Item;
import com.api.receipt_processor.Model.Receipt;
//import com.api.receipt_processor.Service.ReceiptService;
import com.api.receipt_processor.Service.ReceiptService;

@RestController
public class ReceiptController {

    @PostMapping("/receipts/process")
    public ResponseEntity<String> getId(@RequestBody Receipt receipt) {
        String retailer = receipt.getRetailer();
        LocalDate purchaseDate = receipt.getPurchase_Date();
        LocalTime purchaseTime = receipt.getPurchase_Time();
        List<Item> items = receipt.getItems();
        double total = receipt.getTotal();

        Receipt newReceipt = new Receipt(retailer, purchaseDate, purchaseTime, items, total);

        String id = newReceipt.getId();

        ReceiptService.addReceipt(newReceipt);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @GetMapping("/receipts/{id}/points")
    public ResponseEntity<String> getPoints(@PathVariable String id) {
        Receipt receipt = ReceiptService.getReceiptById(id);

        int retailerPts = ReceiptService.retailerPts(receipt);
        int roundPts = ReceiptService.roundPts(receipt);
        int quarterPts = ReceiptService.quarterPts(receipt);
        int pairPts = ReceiptService.pairPts(receipt);
        int descriptionPts = ReceiptService.descriptionPts(receipt);
        int dayPts = ReceiptService.dayPts(receipt);
        int timePts = ReceiptService.timePts(receipt);

        int pts = retailerPts + roundPts + quarterPts + pairPts + descriptionPts + dayPts + timePts;

        String points = "\n\"{points\": " + pts + "}";

        System.out.println("\nretailer pts: " + retailerPts +
                "\nround pts: " + roundPts +
                "\nquarter pts: " + quarterPts +
                "\npair pts: " + pairPts +
                "\ndescription pts: " + descriptionPts +
                "\nday pts: " + dayPts +
                "\ntime pts: " + timePts + points);

        return ResponseEntity.status(HttpStatus.OK).body(points);
    }
}
