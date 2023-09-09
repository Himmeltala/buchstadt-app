package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("carts")
public class Cart {

    private Integer id;
    private Integer num;
    private Integer userId;
    private Integer buchId;

    @TableField(exist = false)
    private Buch buch;

    @TableField(exist = false)
    private Publisher publisher;

    @Data
    static class Buch {
        private Integer id;
        private Float price;
        private Float discount;
        private String name;
    }

    @Data
    static class Publisher {
        private Integer id;
        private String name;
    }

}
