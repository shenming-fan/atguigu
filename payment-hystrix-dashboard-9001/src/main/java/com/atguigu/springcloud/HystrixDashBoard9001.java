package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoard9001
{
    public static void main( String[] args )
    {
        SpringApplication.run(HystrixDashBoard9001.class, args);
    }
}
