package com.microservice_ecommerce.gateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "IDENTITY")
public interface IdentityClient {

    @GetMapping("/api/auth/validate")
    Boolean validateToken(@RequestParam("token") String token);

    @PostMapping("/api/auth/extract")
    String extractToken(@RequestParam("token") String token);

}
