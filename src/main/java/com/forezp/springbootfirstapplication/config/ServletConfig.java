package com.forezp.springbootfirstapplication.config;

import com.forezp.springbootfirstapplication.servlet.HeServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new HeServlet(),"/heServlet");
        return registrationBean;
    }
}
