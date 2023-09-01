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
    private Integer userId;

    @TableField("buch_id")
    private Integer buchId;

    @TableField("collect_date")
    private String collectDate;

    @TableField(exist = false)
    private Buch buch;

    @TableField(exist = false)
    private Publisher publisher;

    @TableField(exist = false)
    private List<Author> authors;

    @Data
    public static class Buch {
        private Integer id;
        private String name;
        private String profile;
        private Float price;
        private Float discount;
        private String cover;
    }

    @Data
    static class Author {
        private String author;
    }

    @Data
    static class Publisher {
        private Integer id;
        private String name;
    }

}
