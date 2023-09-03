package com.buchstadt.pojo;

import com.buchstadt.constant.RegexVals;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {

    private Integer id;

    @Pattern(regexp = RegexVals.UNAME, message = "用户名格式错误！")
    private String username;

    @Pattern(regexp = RegexVals.PWD, message = "密码格式错误！")
    private String password;

    @Pattern(regexp = RegexVals.HTTP, message = "HTTP 格式错误！")
    private String profilePhoto;

    @Pattern(regexp = RegexVals.POSITIVE_INTEGER, message = "等级是整数！")
    private Integer level;

    @Email(message = "电子邮箱格式错误！")
    private String email;

    @Pattern(regexp = RegexVals.PHONE, message = "手机号格式错误！")
    private String phone;

    @Max(value = 50, message = "个人简介最多只能输入 50 个字符！")
    private String profile;

    private String sex;

    private String registerDate;

}
