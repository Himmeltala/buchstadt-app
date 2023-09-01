package com.buchstadt.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.buchstadt.mapper")
@EnableTransactionManagement
public class MybatisConfig extends MybatisConfiguration {

}
