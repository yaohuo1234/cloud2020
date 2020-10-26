package com.cn.test.dgh.consumers.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory factory){
        return new StringRedisTemplate(factory);
    }
    @Bean
    Logger.Level getLogLevel(){
        return Logger.Level.FULL;
    }
}
