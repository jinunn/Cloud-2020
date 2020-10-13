package com.jinunn.springclpud.server.impl;

import com.jinunn.springclpud.server.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author jinunn.
 * @date 2020/10/11 11:18
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String prymentInfo_ok(Integer id) {
        return "prymentInfo_ok的单独服务降级处理类，请稍后再试！";
    }

    @Override
    public String prymentInfo_TimeOut(Integer id) {
        return "prymentInfo_TimeOut的单独处理降级类，请稍后再试!";
    }
}
