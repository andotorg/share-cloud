package org.andot.account.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/***
 * durid 连接池监控， SQL查询监控
 * @author andot
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "druid.configuration")
public class DuridMonitorConfig {

    private String username;
    private String password;
    private String resetDataSource;
    private String denyIpaddr;
    private String allowIpaddr;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setResetDataSource(String resetDataSource) {
        this.resetDataSource = resetDataSource;
    }

    public void setDenyIpaddr(String denyIpaddr) {
        this.denyIpaddr = denyIpaddr;
    }

    public void setAllowIpaddr(String allowIpaddr) {
        this.allowIpaddr = allowIpaddr;
    }

    @Bean
    public ServletRegistrationBean druidServlet() { // 主要实现WEB监控的配置处理
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*"); // 现在要进行druid监控的配置处理操作
        servletRegistrationBean.addInitParameter("allow",this.allowIpaddr); // 白名单
        servletRegistrationBean.addInitParameter("deny", this.denyIpaddr); // 黑名单
        servletRegistrationBean.addInitParameter("loginUsername", this.username); // 用户名
        servletRegistrationBean.addInitParameter("loginPassword", this.password); // 密码
        servletRegistrationBean.addInitParameter("resetEnable", this.resetDataSource); // 是否可以重置数据源
        return servletRegistrationBean ;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*"); // 所有请求进行监控处理
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css, /druid/*");
        return filterRegistrationBean ;
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}
