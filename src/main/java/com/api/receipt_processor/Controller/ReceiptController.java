package com.api.receipt_processor.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.receipt_processor.Model.Item;
import com.api.receipt_processor.Model.Receipt;
//import com.api.receipt_processor.Service.ReceiptService;

@RestController
public class ReceiptController {
    // private ReceiptService receiptService;

    /*
     * @Autowired
     * public ReceiptController(ReceiptService receiptService) {
     * this.receiptService = receiptService;
     * }
     */

    @PostMapping("/receipts/process")
    public ResponseEntity<String> getId(@RequestBody Receipt receipt) {
        String retailer = receipt.getRetailer();
        String purchaseDate = receipt.getPurchase_Date();
        String purchaseTime = receipt.getPurchase_Time();
        List<Item> items = receipt.getItems();
        String total = receipt.getTotal();

        Receipt newReceipt = new Receipt(retailer, purchaseDate, purchaseTime, items, total);

        String id = newReceipt.getId();

        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
