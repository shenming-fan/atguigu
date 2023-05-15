package com.atguigu.springcloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    // gatewayconfig 定义routes
    @Bean
    public RouteLocator customRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("xinwen_route",r -> r.path("/@NASA")
              .uri("http://www.youtube.com/")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteConfig2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("xinwen_route2",r -> r.path("/anime2")
                .uri("http://www.bilibili.com/")).build();
        return routes.build();
    }


}
