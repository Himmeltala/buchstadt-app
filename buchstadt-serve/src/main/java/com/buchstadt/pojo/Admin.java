package com.buchstadt.pojo;

import lombok.Data;

@Data
public class Admin {

    private Integer id;
    private String authority;
    private String username;
    private String password;
    private String phone;
    private String profilePhoto;

}
