package com.herman87.demospringsecurity.controller;

import com.herman87.demospringsecurity.domain.User;
import com.herman87.demospringsecurity.domain.model.UserDTO;
import com.herman87.demospringsecurity.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(OK).body(userService.getAllUsers());
    }

    @GetMapping("/hello")
    ResponseEntity<String> Hello() {
        return ResponseEntity.status(OK).body("Hello word");
    }

    @PostMapping("/user")
    ResponseEntity<Long> createUser(@RequestBody User user) {
        return ResponseEntity.status(CREATED).body(userService.createUser(user));
    }

    @PutMapping("/login")
    ResponseEntity<void> login(@RequestBody UserDTO userDTO) {
        userService.connect(userDTO);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
