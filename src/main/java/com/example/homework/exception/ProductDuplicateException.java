package com.example.homework.exception;

public class ProductDuplicateException extends AllException{

    public ProductDuplicateException() {
        super(ErrorCode.PRODUCT_DUPLICATE_ERROR);
    }
}
