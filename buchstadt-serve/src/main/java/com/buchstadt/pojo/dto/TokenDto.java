package com.buchstadt.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDto {

    private String value;
    private String type;
    private Integer id;
    private String avatar;

}
