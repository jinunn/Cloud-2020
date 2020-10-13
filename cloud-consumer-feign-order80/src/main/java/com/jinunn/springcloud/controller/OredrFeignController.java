package com.jinunn.springcloud.controller;

import com.jinunn.springcloud.entities.CommonResult;
import com.jinunn.springcloud.entities.Payment;
import com.jinunn.springcloud.server.PanymentFeginServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jinunn.
 * @date 2020/10/10 16:51
 */
@RestController
@Slf4j
public class OredrFeignController {

    @Resource
    private PanymentFeginServie panymentFeginServie;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id){
        return  panymentFeginServie.getpaymentByid(id);
    }
}
