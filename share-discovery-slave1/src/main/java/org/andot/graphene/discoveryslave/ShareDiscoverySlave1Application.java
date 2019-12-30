package org.andot.graphene.discoveryslave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 * 注册中心节点1启动类
 * @author Andot
 * @date 2019-7-31 22:25:29
 */
@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class ShareDiscoverySlave1Application {

    public static void main(String[] args) {
        SpringApplication.run(ShareDiscoverySlave1Application.class, args);
    }

}

