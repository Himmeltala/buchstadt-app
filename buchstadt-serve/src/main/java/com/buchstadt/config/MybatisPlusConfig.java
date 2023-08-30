package com.buchstadt.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.buchstadt.mapper")
public class MybatisPlusConfig extends MybatisConfiguration {

    @Override
    public void setMapUnderscoreToCamelCase(boolean mapUnderscoreToCamelCase) {
        super.setMapUnderscoreToCamelCase(true);
    }

}
