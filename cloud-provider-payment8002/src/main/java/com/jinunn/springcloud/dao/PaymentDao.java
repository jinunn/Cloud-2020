package com.jinunn.springcloud.dao;

import com.jinunn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jinunn
 * @date 2020/10/6 20:29
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);
    public Payment getpaymentByid(@Param("id") Long id);
}
