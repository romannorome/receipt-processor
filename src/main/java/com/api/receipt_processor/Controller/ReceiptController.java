package com.api.receipt_processor.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.receipt_processor.Model.Item;
import com.api.receipt_processor.Model.Receipt;

import com.api.receipt_processor.Service.ReceiptService;

@RestController
public class ReceiptController {

    @PostMapping("/receipts/process")
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.OK)
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

        return ResponseEntity.status(HttpStatus.OK).body(points);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleBadRequest(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The receipt is invalid.");
    }

    @ExceptionHandler()
    public ResponseEntity<String> handleNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No receipt found for that ID.");
    }
}
