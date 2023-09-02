package com.buchstadt.utils;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Http {
    OK(200, "请求成功"),
    NO(400, "请求失败"),
    ERROR(500, "代码错误");

    private final Integer code;
    private final String message;

    Http(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
