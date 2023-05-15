package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableFeignClients
public class orderMainFeign80
{
    public static void main( String[] args )
    {

        SpringApplication.run(orderMainFeign80.class,args);
    }
}
