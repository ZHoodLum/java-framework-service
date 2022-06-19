package com.springcloud.service;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //创建
    public int create(Payment payment);
    //查询
    public Payment getPaymentById(@Param("id") Integer id);
}
