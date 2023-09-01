package com.buchstadt.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Buch {

    private Integer id;
    private String name;
    private String profile;
    private Float price;
    private Float discount;
    private String cover;
    private Integer isPrime;
    private String postDate;
    private Integer publisherId;
    private String type;
    private List<Tag> tags;
    private List<Preview> previews;
    private List<Author> authors;
    private Publisher publisher;

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
    public static class Publisher {
        private Integer id;
        private String name;
        private String profilePhoto;
        private String profile;
        private Float desc;
        private Float serv;
        private Float logistics;
    }

}
