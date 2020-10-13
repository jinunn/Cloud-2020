package com.jinunn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 *
 * @author jinunn.
 * @date 2020/10/9 15:18
 */
@RestController
public class PayMentController {

    @Value("${server.port}")
    private  String serverPort;

    @GetMapping("/payment/zk")
    public String  paymentzk(){
        return "springcloud with zookeeper"+serverPort+"/t"+ UUID.randomUUID().toString();
    }
}
