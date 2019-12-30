package org.andot.graphene.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 * 注册中心启动类
 * @author Andot
 * @date 2019-7-31 22:26:45
 */
@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class ShareDiscoveryMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareDiscoveryMasterApplication.class, args);
	}

}

