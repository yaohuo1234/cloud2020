package com.cn.test.dgh.consumers.controller;

import com.cn.test.dgh.jar.results.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private String url="http://CLOUD-ORDER";

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

    @GetMapping("/leftPush/{id}")
    public CommonResp<String> leftPushById(@PathVariable("id") String id){
        return CommonResp.buildSuccess(appName+":"+stringRedisTemplate.opsForList().leftPush("1111:test:list",id)) ;
    }
    @GetMapping("/rightPush/{id}")
    public CommonResp<String> rightPush(@PathVariable("id") String id){
        return CommonResp.buildSuccess(appName+":"+stringRedisTemplate.opsForList().rightPush("1111:test:list",id)) ;
    }

    @GetMapping("/leftPop")
    public CommonResp<String> leftPop(){
        return CommonResp.buildSuccess(appName+":"+stringRedisTemplate.opsForList().leftPop("1111:test:list")) ;
    }
    @GetMapping("/rightPop")
    public CommonResp<String> rightPop(){
        return CommonResp.buildSuccess(appName+":"+stringRedisTemplate.opsForList().rightPop("1111:test:list")) ;
    }


}
