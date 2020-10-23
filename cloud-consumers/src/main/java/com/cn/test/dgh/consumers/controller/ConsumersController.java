package com.cn.test.dgh.consumers.controller;

import com.cn.test.dgh.jar.results.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/consumers")
public class ConsumersController {

    @Value("${spring.application.name}")
    private String appName;

    private String url="http://localhost:9001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getById/{id}")
    public CommonResp<String> getConsumers(@PathVariable("id") String id){
        return CommonResp.buildSuccess(appName+":"+id);
    }

    @GetMapping("/getOrderById/{id}")
    public CommonResp<String> getOrderById(@PathVariable("id") String id){
        return  restTemplate.getForObject(url+"/order/getById/"+id,CommonResp.class);
    }
}
