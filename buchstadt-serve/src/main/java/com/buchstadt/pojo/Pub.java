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
@TableName("pubs")
public class Pub {

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
