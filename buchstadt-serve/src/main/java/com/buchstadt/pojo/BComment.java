package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @package: com.buchstadt.pojo
 * @author: zheng
 * @date: 2023/8/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("b_comments")
public class BComment {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer buchId;

    private Integer userId;

    @TableField("content")
    private String content;

    @TableField("digg")
    private Integer digg;

    @TableField("bury")
    private Integer bury;

    private String type;

    private String postDate;

    @TableField(exist = false)
    private User user;

    @Data
    static class User {
        private Integer id;
        private String username;
        private String profilePhoto;
        private String level;
    }

}
