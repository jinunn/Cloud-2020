package com.jinunn.springvloud;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author jinunn.
 * @date 2020/10/10 19:54
 */
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker  //用断路器功能
public class PaymentHysteixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHysteixMain8001.class,args);
    }

}

