package com.buchstadt.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Publisher {

    private int id;
    private String name;
    private String profilePhoto;
    private String profile;
    private List<Buch> buchs;

    @Data
    public static class Buch {
        private int id;
        private String name;
        private float price;
        private float discount;
        private String cover;
        private String type;
        private List<Author> authors;
    }

    @Data
    public static class Author {
        private int id;
        private String author;
    }

}
