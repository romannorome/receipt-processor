package com.api.receipt_processor.Service;

import org.springframework.stereotype.Service;

import com.api.receipt_processor.Model.Receipt;

@Service
public class ReceiptService {

    public String getId(Receipt reciept) {
        return reciept.getId();
    }
}
