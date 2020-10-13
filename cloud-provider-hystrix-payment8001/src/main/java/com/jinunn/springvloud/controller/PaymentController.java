package com.jinunn.springvloud.controller;

import com.jinunn.springvloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jinunn.
 * @date 2020/10/10 20:06
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String prymentInfo_ok(@PathVariable("id") Integer id){
       return paymentService.prymentInfo_ok(id);
    }
    @GetMapping("/payment/hystrix/out/{id}")
    public String prymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentService.prymentInfo_TimeOut(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return  paymentService.paymentCircuitBreaker(id);
    }
}
