package com.buchstadt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api.path")
public class UnitedApiPathProps {

    String globalPrefix = "api";

}
