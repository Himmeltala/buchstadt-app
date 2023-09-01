package com.buchstadt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private Integer id;
    private String authority;
    private String username;
    private String password;
    private String phone;
    private String profilePhoto;

}
