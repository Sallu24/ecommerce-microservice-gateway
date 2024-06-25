package com.microservice_ecommerce.gateway.auth;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    protected AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CustomerRegisterDTO customerRegisterDTO) {
        return authenticationService.register(customerRegisterDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody CustomerLoginDTO customerLoginDTO) {
        return authenticationService.login(customerLoginDTO);
    }

}
