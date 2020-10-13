package com.jinunn.springcloud.service;

import com.jinunn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author jinunn
 * @date 2020/10/6 20:58
 */
public interface PayMentService {
    public int create(Payment payment);
    public Payment getpaymentByid(Long id);
}
