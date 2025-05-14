package com.api.receipt_processor.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends Throwable {
    public CustomException(String string) {
        // TODO Auto-generated constructor stub
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
    public @ResponseBody String InvalidReceiptException() {
        return "The receipt is invalid";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
    public @ResponseBody String ReceiptNotFoundException() {
        return "No receipt found for that ID";
    }
}
