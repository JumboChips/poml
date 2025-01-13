package com.jumbochips.poml_jpa.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.allowed-origins}")
    private String ALLOW_CROSS_ORIGIN_DOMAIN;

    @Value("${cors.allowed-methods}")
    private String[] ALLOW_METHODS;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALLOW_CROSS_ORIGIN_DOMAIN)
                .allowedMethods(ALLOW_METHODS)
                .allowedHeaders("*")
                .allowCredentials(true)
                .exposedHeaders("Authorization");
    }

}
