package com.buchstadt.utils;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class R<T> {
    private Integer status;
    private final String message;
    private T data;

    private R(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private R(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private R(String message) {
        this.message = message;
    }

    /**
     * 返回《状态码》《状态信息》《数据》
     * 状态码来自--->>枚举
     * 状态信息来自--->>开发人员
     * 数据来自--->>开发人员
     */
    public static <T> R<T> build(Status status, String message, T data) {
        return new R<>(status.getCode(), message, data);
    }

    /**
     * 返回《状态码》《状态信息》《状态信息》
     * 状态码来自--->>枚举
     * 状态信息来自--->>开发人员
     */
    public static <T> R<T> build(Status status, String message) {
        return new R<>(status.getCode(), message);
    }

    /**
     * 返回《状态码》《状态信息》《数据》
     * 状态码来自--->>枚举
     * 状态信息来自--->>枚举
     * 数据来自--->>开发人员
     */
    public static <T> R<T> build(Status status, T data) {
        return new R<>(status.getCode(), status.getMessage(), data);
    }

    /**
     * 返回《状态码》《状态信息》《数据》
     * 状态码来自--->>枚举
     * 状态信息来自--->>枚举
     * 数据来自--->>开发人员
     */
    public static <T> R<T> build(Status status) {
        return new R<>(status.getCode(), status.getMessage());
    }
}
