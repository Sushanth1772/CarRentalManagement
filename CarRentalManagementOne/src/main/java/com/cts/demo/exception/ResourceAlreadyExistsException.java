package com.cts.demo.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ResourceAlreadyExistsException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

  

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
