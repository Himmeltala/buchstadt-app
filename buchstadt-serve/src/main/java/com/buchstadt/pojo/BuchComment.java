package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("buch_comments")
public class BuchComment {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private int buchId;

    private int userId;

    @TableField("content")
    private String content;

    @TableField("digg")
    private int digg;

    @TableField("bury")
    private int bury;

    private String type;

    private String postDate;

    @TableField(exist = false)
    private User user;

    @Data
    static class User {
        private int id;
        private String username;
        private String profilePhoto;
        private String level;
    }

}
