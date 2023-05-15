package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommentResult addPayment(@RequestBody Payment payment){
        CommentResult commentResult = new CommentResult();
        int res = paymentService.createPayment(payment);
        log.info("插入结果："+res);
        if(res>0){
            commentResult.setResult(200,"插入成功，端口是"+port,res);
            return commentResult;
        }else{
            commentResult.setResult(500,"插入失败",res);
            return commentResult;
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommentResult queryPaymentById(@PathVariable("id") Long id){
        CommentResult commentResult = new CommentResult();
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment + "qq");
        if(payment != null){
            commentResult.setResult(200,"查询成功,端口11是"+port,payment);
            return commentResult;
        }else{
            commentResult.setResult(500,"查询失败",null);
            return commentResult;
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() +"\t"+ instance.getHost() +"\t"+instance.getPort()  +"\t"+ instance.getUri());
        }
        return this.discoveryClient;

    }

    @GetMapping("/payment/lb")
    public String getPort(){
        return port;
    }


    @GetMapping("/payment/feign/timeout")
    public String openFeignTimeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
