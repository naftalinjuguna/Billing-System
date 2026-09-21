package com.wifi.bill.auth;

public record RegisterRequest(
    String name,
    String email,
    String phone,
    String password
) {}
