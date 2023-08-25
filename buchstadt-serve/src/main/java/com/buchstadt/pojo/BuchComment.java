package com.buchstadt.pojo;

import lombok.Data;

@Data
public class BuchComment {

    private int id;
    private String content;
    private int digg;
    private int bury;
    private String type;
    private String postDate;
    private User user;

    @Data
    static class User {
        private int id;
        private String username;
        private String profilePhoto;
        private String level;
    }

}
