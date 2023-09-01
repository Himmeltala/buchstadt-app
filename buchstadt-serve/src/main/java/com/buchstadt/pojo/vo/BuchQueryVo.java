package com.buchstadt.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuchQueryVo {

    private Integer isPrime;
    private String name;
    private String type;

}
