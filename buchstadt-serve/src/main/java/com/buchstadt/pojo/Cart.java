package com.buchstadt.pojo;

import lombok.Data;

@Data
public class Cart {

    private int id;
    private int num;
    private Buch buch;
    private Publisher publisher;

    @Data
    static class Buch {
        private int id;
        private float price;
        private float discount;
        private String name;
    }

    @Data
    static class Publisher {
        private int id;
        private String name;
    }

}
