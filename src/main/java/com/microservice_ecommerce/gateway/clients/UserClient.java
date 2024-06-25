package com.microservice_ecommerce.gateway.clients;

import com.microservice_ecommerce.gateway.external.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER")
public interface UserClient {

    @GetMapping("/api/users/internal/user-by-email/{email}")
    User getUserByEmail(@PathVariable("email") String email);

}
