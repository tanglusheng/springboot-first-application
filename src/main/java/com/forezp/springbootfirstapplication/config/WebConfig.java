package com.forezp.springbootfirstapplication.config;

import com.forezp.springbootfirstapplication.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径
        String[] addPathPatterns={
                "/boot/**"
        };
        //不拦截路径
        String[] excludePathPatterns={
                "/boot/index"
        };
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
