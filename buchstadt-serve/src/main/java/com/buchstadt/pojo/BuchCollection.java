package com.buchstadt.pojo;

import lombok.Data;

import java.util.List;

@Data
public class BuchCollection {

    private int id;
    private String collectDate;
    private Buch buch;
    private Publisher publisher;
    private List<Author> authors;

    @Data
    public static class Buch {
        private int id;
        private String name;
        private String profile;
        private float price;
        private float discount;
        private String cover;
    }

    @Data
    static class Author {
        private String author;
    }

    @Data
    static class Publisher {
        private int id;
        private String name;
    }

}
