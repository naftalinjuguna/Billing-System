package com.wifi.bill.auth;

public record LoginRequest(
        String phone,
        String password
        ) {}
