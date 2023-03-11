package com.fzk.cloud.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/web1/account")
public class Web1AccountController
{
    @GetMapping("/test")
    public void test(){
        System.out.println(123);
    }
}
