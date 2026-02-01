package com.example.API.Rate.Limiting.controller;

import com.example.API.Rate.Limiting.dto.LoginRequest;
import com.example.API.Rate.Limiting.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        // Hardcoded users
        if ("user1".equals(request.getUsername()) &&
                "password123".equals(request.getPassword())) {

            String token = JwtUtil.generateToken("user1");
            return Map.of("token", token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
