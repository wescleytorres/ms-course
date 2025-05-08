package com.wescleydev.hr_user.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wescleydev.hr_user.entities.User;
import com.wescleydev.hr_user.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = userRepository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User user = userRepository.findById(id).get();
    return ResponseEntity.ok(user);
  }

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    User user = userRepository.findByEmail(email);
    return ResponseEntity.ok(user);
  }
}
