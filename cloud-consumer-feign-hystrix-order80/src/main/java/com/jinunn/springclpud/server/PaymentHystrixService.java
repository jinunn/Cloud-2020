package com.jinunn.springclpud.server;

import com.jinunn.springclpud.server.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jinunn.
 * @date 2020/10/10 21:55
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String prymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/out/{id}")
    public String prymentInfo_TimeOut(@PathVariable("id") Integer id);
}
