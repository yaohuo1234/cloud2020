package com.cn.test.dgh.hystrixDashboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain {

    public static void  main(String [] args){
        SpringApplication.run(HystrixDashboardMain.class);
    }

}
