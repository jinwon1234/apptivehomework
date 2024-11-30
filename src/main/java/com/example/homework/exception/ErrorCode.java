package com.example.homework.exception;

public enum ErrorCode {
    PRODUCT_DUPLICATE_ERROR("이미 등록되어있는 상품입니다.");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
