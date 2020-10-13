package com.jinunn.springcloud.service.impl;

import com.jinunn.springcloud.dao.PaymentDao;
import com.jinunn.springcloud.entities.Payment;
import com.jinunn.springcloud.service.PayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jinunn
 * @date 2020/10/6 20:59
 */

@Service
public class PayMentServiceImpl implements PayMentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getpaymentByid(Long id) {
        return paymentDao.getpaymentByid(id);
    }
}
