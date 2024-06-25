package com.microservice_ecommerce.gateway.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerRegisterDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 99)
    private String first_name;

    @NotNull
    @Size(min = 1, max = 99)
    private String last_name;

    @Size(min = 1, max = 99)
    @Email
    private String email;

    @Size(min = 1, max = 99)
    private String phone;

    private String password;

    public CustomerRegisterDTO(Long id, String first_name, String last_name, String email, String phone, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 99) String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(@NotNull @Size(min = 1, max = 99) String first_name) {
        this.first_name = first_name;
    }

    public @NotNull @Size(min = 1, max = 99) String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NotNull @Size(min = 1, max = 99) String last_name) {
        this.last_name = last_name;
    }

    public @Size(min = 1, max = 99) @Email String getEmail() {
        return email;
    }

    public void setEmail(@Size(min = 1, max = 99) @Email String email) {
        this.email = email;
    }

    public @Size(min = 1, max = 99) String getPhone() {
        return phone;
    }

    public void setPhone(@Size(min = 1, max = 99) String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerRegisterDTO{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
