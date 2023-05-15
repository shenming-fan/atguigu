package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class orderFeignHystrixMain80
{
    public static void main( String[] args )
    {

        SpringApplication.run(orderFeignHystrixMain80.class,args    );
    }
}
