package com.buchstadt.pojo;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String profilePhoto;
    private Integer level;
    private String email;
    private String phone;
    private String profile;
    private String sex;
    private String registerDate;

}
