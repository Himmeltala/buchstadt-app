package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Cart {

    private Integer id;
    private Integer num;

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
