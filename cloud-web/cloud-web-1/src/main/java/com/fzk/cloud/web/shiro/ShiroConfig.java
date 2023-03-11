package com.fzk.cloud.web.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration public class ShiroConfig
{
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> fMap = new HashMap<>();
        //拦截页面
        fMap.put("/web1/login", "authc");
        //被拦截时返回登录页面
        shiroFilterFactoryBean.setLoginUrl("/web1/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "defaultWebSecurityManager") public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("web1AuthRealm") Web1AuthRealm web1AuthRealm)
    {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(web1AuthRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name = "web1AuthRealm")
    public Web1AuthRealm getWeb1AuthRealm()
    {
        return new Web1AuthRealm();
    }
}
