package com.microservice_ecommerce.gateway.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CredentialsMismatchException extends RuntimeException {

    public CredentialsMismatchException(String message) {
        super(message);
    }

}
