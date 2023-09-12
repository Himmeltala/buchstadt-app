package com.buchstadt.utils;

import lombok.Getter;
import lombok.ToString;

/**
 * @description: Http 状态码枚举类
 * @package: com.buchstadt.utils
 * @author: zheng
 * @date: 2023/8/25
 */
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
