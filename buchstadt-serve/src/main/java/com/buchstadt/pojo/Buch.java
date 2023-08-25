package com.buchstadt.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Buch {

    private int id;
    private String name;
    private String profile;
    private float price;
    private float discount;
    private String cover;
    private int isPrime;
    private String postDate;
    private int publisherId;
    private String type;
    private List<Tag> tags;
    private List<Preview> previews;
    private List<Author> authors;
    private Publisher publisher;

    @Data
    public static class Tag {
        private int id;
        private int buchId;
        private String tag;
    }

    @Data
    public static class Preview {
        private int id;
        private int buchId;
        private String url;
    }

    @Data
    public static class Author {
        private int id;
        private int buchId;
        private String author;
    }

    @Data
    public static class Publisher {
        private int id;
        private String name;
        private String profilePhoto;
        private String profile;
        private float desc;
        private float serv;
        private float logistics;
    }

}
