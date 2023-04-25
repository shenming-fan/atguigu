package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAY_URL = "http://localhost:8001/";


    @GetMapping("consummer/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAY_URL+"payment/create", payment, CommentResult.class);
    }


    @GetMapping("consumer/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAY_URL+"payment/get/"+id, CommentResult.class);
    }

}
