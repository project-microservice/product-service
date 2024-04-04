package com.project.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceExistedException extends RuntimeException {
    public ResourceExistedException(String message){
        super(message);
    }
}
