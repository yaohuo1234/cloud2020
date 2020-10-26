package com.cn.test.dgh.consumers.fegin;

import com.cn.test.dgh.jar.results.CommonResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("cloud-order")
public interface OrderFeigin {


    @GetMapping("/order/getById/{id}")
    CommonResp<String> getOrder(@PathVariable("id") String id);
}
