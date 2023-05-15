package com.atguigu.springcloud.service.impl;


import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payment_timeHandle",commandProperties = {
            //设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法处理，作服务降级fallback
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //休眠3秒
        int timeNumber = 3;
        try { Thread.sleep(timeNumber*1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O哈哈~"+"耗时(秒)";
    }

    public String payment_timeHandle(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+" 系统繁忙，请稍后再试,id: "+id+"\t"+"o(╥﹏╥)o";
    }


    @HystrixCommand(fallbackMethod = "paymentBreakHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败百分比
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 滑动时间窗口期
    })
    @Override
    public String paymentBreak(@PathVariable("id") Integer id){
        if(id < 0){
            throw   new  RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "线程池： "+Thread.currentThread().getName()+" paymentBreak,id: "+id+"\t "+ "调用成功，流水号："+serialNumber;
    }

    public String paymentBreakHandler(@PathVariable("id") Integer id ){
        return "id不能为负数："+id + "哭唧唧";
    }
}
