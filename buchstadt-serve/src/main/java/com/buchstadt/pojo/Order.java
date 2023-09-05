package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("orders")
public class Order {

    private Integer id;
    private String date;
    private Float total;
    private String location;
    private String phone;
    private String holder;
    private String status;
    private String method;

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
