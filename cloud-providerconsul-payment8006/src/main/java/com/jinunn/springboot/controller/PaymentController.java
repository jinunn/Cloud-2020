package com.jinunn.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author jinunn.
 * @date 2020/10/9 18:11
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private  String serverPort;

    @GetMapping("/payment/consul")
    public String  paymentconsul(){
        return "springcloud with zookeeper"+serverPort+"/t"+ UUID.randomUUID().toString();
    }
}
