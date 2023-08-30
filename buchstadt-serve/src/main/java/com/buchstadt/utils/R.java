package com.buchstadt.utils;

import lombok.Getter;
import lombok.ToString;

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

    /**
     * 返回《状态码》《状态信息》《数据》
     * 状态码来自--->>枚举
     * 状态信息来自--->>开发人员
     * 数据来自--->>开发人员
     */
    public static <T> R<T> build(HttpCodes httpCodes, String message, T data) {
        return new R<>(httpCodes.getCode(), message, data);
    }

    /**
     * 返回《状态码》《状态信息》《状态信息》
     * 状态码来自--->>枚举
     * 状态信息来自--->>开发人员
     */
    public static <T> R<T> build(HttpCodes httpCodes, String message) {
        return new R<>(httpCodes.getCode(), message);
    }

    /**
     * 返回《状态码》《状态信息》《数据》
     * 状态码来自--->>枚举
     * 状态信息来自--->>枚举
     * 数据来自--->>开发人员
     */
    public static <T> R<T> build(HttpCodes httpCodes, T data) {
        return new R<>(httpCodes.getCode(), data);
    }

    /**
     * 返回《状态码》《状态信息》《数据》
     * 状态码来自--->>枚举
     * 状态信息来自--->>枚举
     * 数据来自--->>开发人员
     */
    public static <T> R<T> build(HttpCodes httpCodes) {
        return new R<>(httpCodes.getCode());
    }
}
