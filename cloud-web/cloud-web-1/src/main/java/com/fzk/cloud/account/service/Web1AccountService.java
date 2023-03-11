package com.fzk.cloud.account.service;

import com.fzk.cloud.account.entity.Web1Account;

public interface Web1AccountService
{
    Web1Account selectByName(String name);
}
