package com.forezp.springbootfirstapplication.config;

import com.forezp.springbootfirstapplication.filter.HeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean heFilterRegistrationBean(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean(new HeFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    /*
    需要配置:spring.http.encoding.enabled=false
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();

        CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
