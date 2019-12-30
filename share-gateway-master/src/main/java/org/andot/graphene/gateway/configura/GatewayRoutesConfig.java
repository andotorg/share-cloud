package org.andot.graphene.gateway.configura;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().route(
                r->r.path("/auth/**")
                        .filters(
                                f->f.stripPrefix(1)
                        )
                        .uri("http://localhost:8081")
        ).build();
    }

}
