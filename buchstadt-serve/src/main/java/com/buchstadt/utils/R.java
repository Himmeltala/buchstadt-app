package com.buchstadt.utils;

import lombok.Getter;
import lombok.ToString;

/**
 * @description: 数据响应封装类
 * @package: com.buchstadt.utils
 * @author: zheng
 * @date: 2023/8/25
 */
@Getter
@ToString
public class R<T> {

    private Integer status;
    private String message;
    private T data;

    private R(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private R(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    private R(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private R(Integer status) {
        this.status = status;
    }

    private R(String message) {
        this.message = message;
    }

    public static <T> R<T> build(Http http, String message, T data) {
        return new R<>(http.getCode(), message, data);
    }

    public static <T> R<T> build(Http http, String message) {
        return new R<>(http.getCode(), message);
    }

    public static <T> R<T> build(Http http, T data) {
        return new R<>(http.getCode(), data);
    }

    public static <T> R<T> build(Http http) {
        return new R<>(http.getCode());
    }

}
