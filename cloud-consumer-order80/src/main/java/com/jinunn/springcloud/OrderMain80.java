package com.jinunn.springcloud;

import com.jinunn.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)  //替换为自己写的随机负载
public class OrderMain80 {
    public static void main(String[] args) {

            SpringApplication.run(OrderMain80.class,args);
    }
}