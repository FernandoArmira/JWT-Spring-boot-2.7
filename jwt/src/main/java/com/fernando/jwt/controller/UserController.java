package com.fernando.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public UserMessage userEndpoint() {
        return new UserMessage("Hello user!");
    }

    @GetMapping("/admin")
    public UserMessage adminEndpoint() {
        return new UserMessage("Hello admin!");
    }
}
