package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentBreak(@PathVariable("id") Integer id);
}
