package com.example.homework.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AllException.class)
    public String ProductExceptionHandler(AllException e, Model model) {
        model.addAttribute("duplicateError",e.getMessage());
        return "addProduct";
    }
}
