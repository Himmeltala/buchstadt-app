package com.buchstadt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring")
public class GlobalUrlProps {

    String globalPrefix = "api";

}
