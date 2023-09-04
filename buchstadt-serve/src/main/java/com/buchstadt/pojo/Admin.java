package com.buchstadt.pojo;

import com.buchstadt.constant.ValidRegexVals;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private Integer id;

    @Pattern(regexp = ValidRegexVals.AUTH, message = "权限格式出错！")
    private String authority;

    @Pattern(regexp = ValidRegexVals.UNAME, message = "用户名格式错误！")
    private String username;

    @Pattern(regexp = ValidRegexVals.PWD, message = "密码格式出错！")
    private String password;

    @Pattern(regexp = ValidRegexVals.PHONE, message = "手机号格式出错！")
    private String phone;

    @Pattern(regexp = ValidRegexVals.HTTP, message = "Http 格式出错！")
    private String profilePhoto;

}
