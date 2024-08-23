package com.codeWithProject.employee.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/api/**")
        .allowedOrigins("http://localhost:3000")
        .allowedOrigins("http://localhost:9998")
        .allowedMethods("*")
        .allowedHeaders("*")
        .allowCredentials(false);
    }
}
