package com.cn.test.dgh.consumers.service;

import com.cn.test.dgh.consumers.fegin.OrderFeigin;
import com.cn.test.dgh.jar.results.CommonResp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ConsumersService {

    @Resource
    private OrderFeigin  orderFeigin;

    @HystrixCommand(fallbackMethod="getHystrixOrderById")
    public CommonResp <String> getOrderById(String id){
        int a=10/0;
        return  orderFeigin.getOrder(id);
    }

    public CommonResp<String>  getHystrixOrderById(String id){
        return CommonResp.buildError("系统繁忙,请稍后重试");
    }
}
