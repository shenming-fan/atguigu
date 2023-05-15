package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class Getway9527Main
{
    public static void main( String[] args )
    {
        SpringApplication.run(Getway9527Main.class, args);
    }
}
