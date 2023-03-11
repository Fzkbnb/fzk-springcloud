package com.fzk.cloud.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean myFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");// 拦截所有请求
        // registration.addInitParameter("paramName", "paramValue");//可在init方法中拿到该值
        registration.setName("myFilter");
        registration.setOrder(1);// 优先级设置，1最大
        return registration;
    }
}
