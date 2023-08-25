package com.buchstadt.params;

import lombok.Data;

import java.util.List;

@Data
public class PayForData {

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
