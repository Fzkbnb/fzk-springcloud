package com.fzk.cloud.web.auth.vo;

import lombok.Data;

@Data public class AuthParam
{
    private String name;

    private String password;

    private String authCode;
}
