package com.example.sns.order.controller.dto;

public record ResultDto<T>(
        int code,
        String message,
        T data
) {
    public static <T> ResultDto<T> success(T data) {
        return new ResultDto<>(200, "success", data);
    }

    public static <T> ResultDto<T> fail(String message) {
        return new ResultDto<>(401, message, null);
    }
}
