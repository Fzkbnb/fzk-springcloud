package com.fzk.springcloud.service;

@org.apache.dubbo.config.annotation.DubboService public class SampleServiceImpl implements SampleService
{
    @Override public String findById(Long id)
    {
        // todo dao层需要后续补充
        return "测试成功";
    }
}
