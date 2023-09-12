package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.pojo
 * @author: zheng
 * @date: 2023/8/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("buchs")
public class Buch {

    private Integer id;
    private String name;
    private String profile;
    private Float price;
    private Float discount;
    private String cover;
    private Integer isPrime;
    private String postDate;
    private Integer pubId;
    private String type;

    @TableField(exist = false)
    private List<Tag> tags;

    @TableField(exist = false)
    private List<Preview> previews;

    @TableField(exist = false)
    private List<Author> authors;

    @TableField(exist = false)
    private Pub pub;

    @Data
    public static class Tag {
        private Integer id;
        private Integer buchId;
        private String tag;
    }

    @Data
    public static class Preview {
        private Integer id;
        private Integer buchId;
        private String url;
    }

    @Data
    public static class Author {
        private Integer id;
        private Integer buchId;
        private String author;
    }

    @Data
    public static class Pub {
        private Integer id;
        private String name;
        private String profilePhoto;
        private String profile;
        private Float desc;
        private Float serv;
        private Float logistics;
    }

}
