package com.taivn.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tai VN
 * @date 1/13/2023
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route("customerServiceRouteId", route -> route.path("/api/v1/customers/**").uri("http://localhost:8080")) // static route
                .route("fraudCheckServiceRouteId", route -> route.path("/api/v1/fraud-check/**").uri("lb://FRAUD-SERVICE")) // dynamic route
                .build();
    }
}
