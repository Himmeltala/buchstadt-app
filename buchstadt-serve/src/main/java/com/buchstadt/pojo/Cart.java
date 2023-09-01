package com.buchstadt.pojo;

import lombok.Data;

@Data
public class Cart {

    private Integer id;
    private Integer num;
    private Buch buch;
    private Publisher publisher;

    @Data
    static class Buch {
        private Integer id;
        private Float price;
        private Float discount;
        private String name;
    }

    @Data
    static class Publisher {
        private Integer id;
        private String name;
    }

}
