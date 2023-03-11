package com.fzk.cloud.account.service.impl;

import com.fzk.cloud.account.entity.Web1Account;
import com.fzk.cloud.account.mapper.Web1AccountMapper;
import com.fzk.cloud.account.service.Web1AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Web1AccountServiceImpl implements Web1AccountService
{
//    @Autowired
//    Web1AccountMapper web1AccountMapper;

    @Override
    public Web1Account selectByName(String name)
    {
        Web1Account account = new Web1Account();
        account.setId(1L);
        account.setName("fzk");
        account.setPassword("123");
        //        return web1AccountMapper.selectByName(name);
        return account;
    }
}
