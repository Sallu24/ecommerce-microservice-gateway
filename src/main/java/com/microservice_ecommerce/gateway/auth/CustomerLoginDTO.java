package com.microservice_ecommerce.gateway.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class CustomerLoginDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public CustomerLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerLoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
