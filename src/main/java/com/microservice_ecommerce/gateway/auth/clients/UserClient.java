package com.microservice_ecommerce.gateway.auth.clients;

import com.microservice_ecommerce.gateway.auth.CustomerRegisterDTO;
import com.microservice_ecommerce.gateway.auth.external.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER")
public interface UserClient {

    @GetMapping("/api/users/internal/user-exists/{email}")
    Boolean userExistsByEmail(@PathVariable("email") String email);

    @GetMapping("/api/users/internal/user-by-email/{email}")
    User getUserByEmail(@PathVariable("email") String email);

    @GetMapping("/api/users/{id}")
    User getUser(@PathVariable("id") Long id);

    @PostMapping("/api/users/internal")
    User createUser(@RequestBody CustomerRegisterDTO customerRegisterDTO);

}
