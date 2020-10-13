package com.jinunn.springcloud.controller;

import com.jinunn.springcloud.entities.CommonResult;
import com.jinunn.springcloud.entities.Payment;
import com.jinunn.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jinunn
 * @date 2020/10/6 21:00
 */
@RestController
@Slf4j
public class PayMentController {

    @Resource
    private PayMentService payMentService;
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取注册中心已经注册的服务名
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("*******"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"/t"+instance.getPort()+"/t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
