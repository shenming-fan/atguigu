package com.atguigu.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class orderServiceFallBack implements orderService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "类的fallback：orderServiceFallBack: paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "类的fallback：orderServiceFallBack: paymentInfo_TimeOut";
    }
}
