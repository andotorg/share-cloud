package org.andot.share.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 * OAuth2 认证服务器主入口
 * @author Andot
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"org.andot.share.oauth.server.client"})
public class OauthAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthAuthorizationApplication.class, args);
    }

}
