package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {


    @Resource
    private RestTemplate restTemplate;
    private static final String PAYMENT_URL = "http://consul-provider-payment";


    @GetMapping("/consumer/order/consul")
    public String orderConsul(){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
