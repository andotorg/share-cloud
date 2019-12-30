package org.andot.share.oauth.server.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Andot
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableResourceServer
public class OauthResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthResourceApplication.class, args);
    }
}
