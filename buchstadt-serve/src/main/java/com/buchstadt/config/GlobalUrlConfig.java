package com.buchstadt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @package: com.buchstadt.config
 * @author: zheng
 * @date: 2023/8/25
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring")
public class GlobalUrlConfig {

    String globalPrefix = "api";

}
