package com.fzk.cloud.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    MyInterCeptor myInterCeptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 第一个拦截器, 拦截所有请求,但过滤掉部分请求，一般静态资源需要过滤，此处仅供参考
        registry.addInterceptor(myInterCeptor).addPathPatterns("/**").excludePathPatterns("/static/**");
        // 如需配置更多自定义拦截器，在下方追加
        // registry.addInterceptor(myInterceptortwo).addPathPatterns("/**");
    }
}
