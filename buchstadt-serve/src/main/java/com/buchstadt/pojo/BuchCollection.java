package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("buch_collections")
public class BuchCollection {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private int userId;

    @TableField("buch_id")
    private int buchId;

    @TableField("collect_date")
    private String collectDate;

    private Buch buch;
    private Publisher publisher;
    private List<Author> authors;

    @Data
    public static class Buch {
        private int id;
        private String name;
        private String profile;
        private float price;
        private float discount;
        private String cover;
    }

    @Data
    static class Author {
        private String author;
    }

    @Data
    static class Publisher {
        private int id;
        private String name;
    }

}
