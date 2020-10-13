package com.jinunn.springcloud.controller;

import com.jinunn.springcloud.entities.CommonResult;
import com.jinunn.springcloud.entities.Payment;
import com.jinunn.springcloud.service.PayMentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author jinunn
 * @date 2020/10/6 21:00
 */
@RestController
public class PayMentController {

    @Resource
    private PayMentService payMentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = payMentService.create(payment);
        if (result>0){
            return  new CommonResult(200,"插入成功,server："+serverPort,result);
        }else {
            return new CommonResult(201,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult getpaymentByid(@PathVariable("id") Long id){
        Payment payment = payMentService.getpaymentByid(id);
        if (payment!= null){
            return  new CommonResult(200,"查询成功,server:"+serverPort,payment);
        }else {
            return  new CommonResult(201,"查询数据失败",null);
        }
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
