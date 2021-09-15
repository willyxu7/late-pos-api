package com.lateras.latepos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends IllegalArgumentException{
    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
