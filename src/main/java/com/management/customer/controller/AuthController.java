package com.management.customer.controller;

import com.management.customer.model.request.AuthRequest;
import com.management.customer.model.request.UpdatePasswordRequest;
import com.management.customer.service.UserService;
import com.management.customer.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        userService.register(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @PutMapping("updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("validate")
    public ResponseEntity<?> validateToken() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
