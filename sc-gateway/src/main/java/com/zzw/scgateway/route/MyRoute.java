package com.zzw.scgateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRoute {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUrl = "http://httpbin.org:80";
        return builder.routes()
                .route(p ->
                        p.path("/get")
                                .filters(f -> f.addRequestHeader("Hello", "World"))
                                .uri(httpUrl))
                .route(p ->
                        p.host("*.hystrix.com")
                                .filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
                                .uri(httpUrl))
                .build();
    }
}
