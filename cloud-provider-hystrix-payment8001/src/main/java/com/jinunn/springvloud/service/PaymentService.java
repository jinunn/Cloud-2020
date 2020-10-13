package com.jinunn.springvloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jinunn.
 * @date 2020/10/10 19:56
 */
public interface PaymentService {
    public String prymentInfo_ok(Integer id);
    public String prymentInfo_TimeOut(Integer id);
    public String paymentCircuitBreaker(Integer id);
}
