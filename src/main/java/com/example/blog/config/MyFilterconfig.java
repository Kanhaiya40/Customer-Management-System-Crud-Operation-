package com.example.blog.config;

import com.example.blog.filter.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterconfig {
    @Bean
    public FilterRegistrationBean<MyNewFilter> registrationBean()
    {
        FilterRegistrationBean<MyNewFilter> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyNewFilter());
        registrationBean.addUrlPatterns("/customer/*");
        return  registrationBean;
    }

}
