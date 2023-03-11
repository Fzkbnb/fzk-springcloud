package com.fzk.cloud.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器，需要在相应spring配置类中注入容器 不建议使用@WebFilter注入，因为指定order不生效
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("进入MyFilter");
        // int a = 1/0;
        //必须执行下方代码，否则请求会卡住
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
