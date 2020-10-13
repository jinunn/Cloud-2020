package com.jinunn.springboot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jinunn.
 * @date 2020/10/9 16:58
 */
@Configuration
public class ApplicationContextBean {

    @Bean
    @LoadBalanced  //赋予restTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
