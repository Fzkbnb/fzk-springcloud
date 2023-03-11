package com.fzk.cloud.web.auth.controller;

import com.fzk.cloud.web.auth.vo.AuthParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web1")
public class AuthController
{
    @GetMapping("/login")
    public String login(AuthParam param)
    {
        param.setName("fzk");
        param.setPassword("1213");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken userToken = new UsernamePasswordToken(param.getName(), param.getPassword());
        subject.login(userToken);//执行这一步后，将调用realm逻辑
        return "登录认证成功";
    }
//    @PostMapping("/login")
//    public void (@RequestBody AuthParam param)
//    {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken userToken = new UsernamePasswordToken(param.getName(), param.getPassword());
//        subject.login(userToken);//执行这一步后，将调用realm逻辑
//    }
}
