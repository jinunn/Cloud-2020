package com.jinunn.springcloud.server;

import com.jinunn.springcloud.entities.CommonResult;
import com.jinunn.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jinunn.
 * @date 2020/10/10 16:43
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PanymentFeginServie {

    @GetMapping("/payment/{id}")
    public CommonResult getpaymentByid(@PathVariable("id") Long id);

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment);
}
