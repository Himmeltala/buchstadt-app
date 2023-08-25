package com.buchstadt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.buchstadt.mapper")
public class BuchstadtApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuchstadtApplication.class, args);
    }

}
