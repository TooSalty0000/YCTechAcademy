package com.example.sns.order.controller.dto;

public record ResultDto<T>(
        int code,
        String message,
        T data
) {

}
