package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Integer id;
    private String date;
    private Float total;
    private String location;
    private String holderPhone;
    private String holderName;
    private String status;
    private String payway;

    @TableField(exist = false)
    private List<Item> items;

    @Data
    static class Item {
        private Integer id;
        private String name;
        private Float price;
        private Float discount;
        private String cover;
        private Integer num;
    }

}
