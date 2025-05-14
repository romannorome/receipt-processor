package com.api.receipt_processor.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReceiptExceptions extends RuntimeException {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
    public String InvalidReceiptException() {
        return "The receipt is invalid";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
    public String ReceiptNotFoundException() {
        return "No receipt found for that ID";
    }
}
