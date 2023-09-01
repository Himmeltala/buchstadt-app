package com.buchstadt.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {

    private Integer id;
    private String date;
    private Float total;
    private String location;
    private String holderPhone;
    private String holderName;
    private String status;
    private String payway;

}
