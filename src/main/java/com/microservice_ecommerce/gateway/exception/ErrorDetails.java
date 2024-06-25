package com.microservice_ecommerce.gateway.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    protected LocalDateTime timestamp;
    protected String message;
    protected String details;

    public ErrorDetails() {
    }

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
