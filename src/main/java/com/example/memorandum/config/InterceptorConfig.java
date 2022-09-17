package com.example.memorandum.config;

import com.example.memorandum.intecptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yeah
 * @create 2022/9/15
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/regist")
                .excludePathPatterns("/favicon.ico", "/error", "/swagger-resources/**",
                "/webjars/**", "/v2/**", "/doc.html", "**/swagger-ui.html",
                "/swagger-ui.html/**");

    }
}
