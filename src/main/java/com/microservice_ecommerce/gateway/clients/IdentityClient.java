package com.microservice_ecommerce.gateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "IDENTITY")
public interface IdentityClient {

    @PostMapping("/api/auth/validate")
    Long validateTokenAndGetUserDetails(@RequestParam("token") String token);

}
