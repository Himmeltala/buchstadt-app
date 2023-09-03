package com.buchstadt.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayVo {

    private Integer id;
    private Float total;
    private String location;
    private String holderPhone;
    private String holderName;
    private String payway;
    private List<Item> items;

    @Data
    public static class Item {
        private Integer orderId;
        private Integer buchId;
        private Integer num;
    }

}
