package com.buchstadt.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayVo {

    private int id;
    private int userId;
    private float total;
    private String location;
    private String holderPhone;
    private String holderName;
    private String payway;
    private List<Item> items;

    @Data
    public static class Item {
        private int orderId;
        private int buchId;
        private int num;
    }

}
