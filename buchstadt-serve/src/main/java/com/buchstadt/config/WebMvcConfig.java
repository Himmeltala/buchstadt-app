package com.buchstadt.config;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.interceptor.PermissionInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private GlobalUrlConfig urlConfig;

    @Resource
    private PermissionInterceptor permissionInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(
                urlConfig.getGlobalPrefix(),
                c -> c.isAnnotationPresent(GlobalUrl.class));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(permissionInterceptor)
                .addPathPatterns("/api/*/auth/**")
                .excludePathPatterns("/api/*/public/**");
    }

}
