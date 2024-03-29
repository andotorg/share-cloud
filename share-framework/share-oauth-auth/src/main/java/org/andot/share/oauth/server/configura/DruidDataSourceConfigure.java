package org.andot.share.oauth.server.configura;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidDataSourceConfigure {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource shareDruidDataSource(){
        return new DruidDataSource();
    }
}
