package org.andot.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 角色权限控制服务
 * @author lucas
 * @since 1.0
 */

@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
@EnableSwagger2
@SpringBootApplication
public class ShareAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShareAccountApplication.class, args);
    }

}
