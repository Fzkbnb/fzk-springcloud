package com.fzk.cloud.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 自定义拦截器，这里没有直接实现HandlerInterceptor ，改为继承HandlerInterceptor的默认实现类，节省代码
 * 请根据需求自行选择实现方式，此处仅供参考
 */
@Component
public class MyInterCeptor extends HandlerInterceptorAdapter
{

}
