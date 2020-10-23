package com.cn.test.dgh.order.controller;

import com.cn.test.dgh.jar.results.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/getById/{id}")
    public CommonResp<String> getOrder(@PathVariable("id") String id){
        return CommonResp.buildSuccess(appName+":"+id);
    }

}
