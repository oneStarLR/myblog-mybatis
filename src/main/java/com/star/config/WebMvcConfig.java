package com.star.config;

import com.star.aspect.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebMvcConfig
 * @Description: TODO
 * @Author ONESTAR
 * @Date: 2021/1/22 21:53
 * @微信：YXK-ONESTAR
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;
    @Bean
    public SessionInterceptor tokenVerifyInterceptor() {
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor);
        registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
