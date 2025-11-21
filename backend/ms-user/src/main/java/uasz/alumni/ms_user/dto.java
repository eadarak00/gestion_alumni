package com.gestional.msuser.dto;

public record ValiderCodeRequest(String email, String code) {}
public record RenvoyerCodeRequest(String email) {}
public record ApiResponse(boolean success, String message) {}
