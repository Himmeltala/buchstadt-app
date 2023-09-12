package com.buchstadt.constant;

/**
 * @description:
 * @package: com.buchstadt.constant
 * @author: zheng
 * @date: 2023/9/1
 */
public class ValidRegexVals {

    public static final String UNAME = "^(?![_-])[\\u4e00-\\u9fa5a-zA-Z][\\u4e00-\\u9fa5a-zA-Z0-9_-]{4,16}$";

    public static final String AUTH = "超级管理员|普通管理员";

    public static final String PWD = "^[a-zA-Z0-9.]{8,16}$";

    public static final String PHONE = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";

    public static final String HTTP = "^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*$";

    public static final String POSITIVE_INTEGER = "^[1-9]\\d*$";

}
