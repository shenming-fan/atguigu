package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class orderConsulMain80
{
    public static void main( String[] args )
    {
        SpringApplication.run(orderConsulMain80.class,args);
    }
}
