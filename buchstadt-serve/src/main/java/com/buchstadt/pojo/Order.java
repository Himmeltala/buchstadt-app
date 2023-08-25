package com.buchstadt.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private int id;
    private String date;
    private float total;
    private String location;
    private String holderPhone;
    private String holderName;
    private String status;
    private String payway;
    private List<Item> items;

    @Data
    static class Item {
        private int id;
        private String name;
        private float price;
        private float discount;
        private String cover;
        private int num;
    }

}
