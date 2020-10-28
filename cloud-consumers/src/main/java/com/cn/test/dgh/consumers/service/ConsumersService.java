package com.cn.test.dgh.consumers.service;

import com.cn.test.dgh.consumers.fegin.OrderFeigin;
import com.cn.test.dgh.jar.results.CommonResp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ConsumersService {

    @Resource
    private OrderFeigin  orderFeigin;

    @HystrixCommand(fallbackMethod="getHystrixOrderById",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少跳闸

    })
    public CommonResp <String> getOrderById(String id){
        if(Integer.valueOf(id)>0){
            int a=10/0;
        }
        return  orderFeigin.getOrder(id);
    }

    public CommonResp<String>  getHystrixOrderById(String id){
        return CommonResp.buildError("系统繁忙,请稍后重试:"+id);
    }
}
