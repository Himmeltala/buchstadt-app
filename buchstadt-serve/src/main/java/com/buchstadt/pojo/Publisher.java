package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Publisher {

    private Integer id;
    private String name;
    private String profilePhoto;
    private String profile;

    @TableField(exist = false)
    private List<Buch> buchs;

    @Data
    public static class Buch {
        private Integer id;
        private String name;
        private Float price;
        private Float discount;
        private String cover;
        private String type;
        private List<Author> authors;
    }

    @Data
    public static class Author {
        private Integer id;
        private String author;
    }

}
