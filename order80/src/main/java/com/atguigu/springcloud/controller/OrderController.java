package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.ws.Service;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

//    private static final String PAY_URL = "http://localhost:8001/";
    private static final String PAY_URL = "http://PAYMENT-SERVICE/";


    @GetMapping("consummer/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAY_URL+"payment/create", payment, CommentResult.class);
    }


    @GetMapping("consumer/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAY_URL+"payment/get/"+id, CommentResult.class);
    }


    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommentResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommentResult> forEntity = restTemplate.getForEntity(PAY_URL + "payment/get/" + id, CommentResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommentResult(444, "操作失败");
        }
    }


    @GetMapping("consumer/payment/create2")
    public CommentResult<Payment> create2 (@RequestBody Payment payment){
        ResponseEntity<CommentResult> responseEntity =  restTemplate.postForEntity(PAY_URL+"payment/create",payment,CommentResult.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else {
            return new CommentResult(444,"插入失败");
        }
    }


    @GetMapping("/consumer/payment/lb")
    public String PaymentLb(){
        List<ServiceInstance> serviceInstance = discoveryClient.getInstances("PAYMENT-SERVICE");
        if(serviceInstance == null || serviceInstance.size() <= 0){
            return null;
        }else {
            ServiceInstance instance = loadBalancer.instances(serviceInstance);
            return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
        }
    }
}
