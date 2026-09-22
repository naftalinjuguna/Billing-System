package com.wifi.bill.auth;

public record LoginRequest(
        String email,
        String password
        ) {}
