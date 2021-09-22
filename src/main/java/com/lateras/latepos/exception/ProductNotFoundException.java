package com.lateras.latepos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends IllegalArgumentException{
    public ProductNotFoundException() {super();}

    public ProductNotFoundException(String message) {
        super(message);
    }
}
