package com.fzk.springcloud;

import com.fzk.springcloud.service.SampleService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class Provider2Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Provider2Application.class, args);
    }

    @DubboReference
    private                   SampleService sampleService;

    @Value("${test}")
    private String        test;

    @GetMapping("/test")
    public String test()
    {
        return test + sampleService.findById(1L);
    }
}