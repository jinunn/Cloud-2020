package com.jinunn.springclpud.controller;

import com.jinunn.springclpud.server.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author jinunn.
 * @date 2020/10/10 21:58
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMenthod")  //全局的
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String prymentInfo_ok(@PathVariable("id") Integer id){
       return paymentHystrixService.prymentInfo_ok(id);
    }


    @GetMapping("/consumer/payment/hystrix/out/{id}")
    //加入@HystrixCommand注解实现断路器功能,HystrixProperty设置超时的时间。
    //@HystrixCommand(fallbackMethod = "prymentTimeOutFallbackMethod",commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    //})
    @HystrixCommand
    public String prymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age=10/3;
        return paymentHystrixService.prymentInfo_TimeOut(id);
    }
    public String prymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请10秒钟后再试！/(ㄒoㄒ)/~~ ";

    }

    //下面是全局fallback
    public String payment_Global_FallbackMenthod(){
        return "Global异常处理信息，请稍后再试！/(ㄒoㄒ)/~~";
    }
}
