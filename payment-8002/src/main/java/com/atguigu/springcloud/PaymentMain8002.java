package com.atguigu.springcloud;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
