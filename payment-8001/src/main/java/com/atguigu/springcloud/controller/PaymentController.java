package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    public CommentResult addPayment(@RequestBody Payment payment){
        CommentResult commentResult = new CommentResult();
        int res = paymentService.createPayment(payment);
        log.info("插入结果："+res);
        if(res>0){
            commentResult.setResult(200,"插入成功",res);
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
            commentResult.setResult(200,"查询成功",payment);
            return commentResult;
        }else{
            commentResult.setResult(500,"查询失败",null);
            return commentResult;
        }
    }
}
