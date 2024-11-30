package com.example.homework.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(

        @Size(min = 1, max=5, message = "상품명은 최소 1글자 최대 5글자입니다.")
        String name,

        @Min(value = 1000, message = "가격은 최소 1000원 입니다.")
        @Max(value = 5000, message = "가격은 최대 5000원 입니다.")
        int price,

        @Max(value = 999, message = "수량은 최대 999개입니다.")
        int quantity
) {
}
