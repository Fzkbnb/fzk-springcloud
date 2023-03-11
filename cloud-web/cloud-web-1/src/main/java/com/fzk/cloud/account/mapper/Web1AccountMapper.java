package com.fzk.cloud.account.mapper;

import com.fzk.cloud.account.entity.Web1Account;


//@Mapper
public interface Web1AccountMapper
{
//    @Select("select * from web1_account where name = #{name}")
    Web1Account selectByName(String name);
}
