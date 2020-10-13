package com.jinunn.springvloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.jinunn.springvloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author jinunn.
 * @date 2020/10/10 19:58
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问，肯定ok的方法
     * @param id
     * @return
     */
    @Override
    public String prymentInfo_ok(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+"prymentInfo_ok,id：  "+id+"\t"+"O(∩_∩)O哈哈！";
    }

    //加入@HystrixCommand注解实现断路器功能,HystrixProperty设置超时的时间。
    @HystrixCommand(fallbackMethod = "prymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })

    @Override
    public String prymentInfo_TimeOut(Integer id) {
        int timeNumber=3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+"prymentInfo_TimeOut,id：  "+id+"\t"+"O(∩_∩)O哈哈！"+"耗时（秒）"+timeNumber;
    }
    public String prymentInfo_TimeOutHandler(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"程序运行繁忙或报错,请稍后再试！ , id：  "+id+"\t"+"/(ㄒoㄒ)/~~";

    }

    //服务熔断
    @HystrixCommand(fallbackMethod="paymentCircuitBreakerFallback", commandProperties={
            @HystrixProperty(name = "circuitBreaker.enabled" ,value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数超过了峰值，断路器将会从关闭状态打开
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期 "
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException();
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t "+"调用成功,流水号: "+serialNumber;
    }
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "id不能为负数,请稍后再试~ id: "+ id;
    }
}
