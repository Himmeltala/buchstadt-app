package com.buchstadt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.buchstadt.mapper")
public class MybatisPlusConfig {

}
