package com.wescleydev.hr_oauth.feignclientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.wescleydev.hr_oauth.entities.User;

@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

  @GetMapping(value = "/{id}")
  ResponseEntity<User> findById(@PathVariable Long id);

  @GetMapping(value = "/search")
  ResponseEntity<User> findByEmail(@RequestParam String email);
}
