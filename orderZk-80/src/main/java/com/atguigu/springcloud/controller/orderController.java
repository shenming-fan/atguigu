package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class orderController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    private String paymentUrl = "http://payment-service";


    @GetMapping("/consumer/order/zk")
    public String testZk(){
        return restTemplate.getForObject(paymentUrl+"/payment/zk",String.class);
    }


}
