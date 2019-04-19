package com.forezp.springbootfirstapplication.config;

import com.forezp.springbootfirstapplication.filter.HeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean heFilterRegistrationBean(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean(new HeFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
