package com.example.homework.exception;

public class AllException extends RuntimeException{
    private final ErrorCode errorCode;

    public AllException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }
}
