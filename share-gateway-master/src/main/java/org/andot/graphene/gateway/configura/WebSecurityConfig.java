package org.andot.graphene.gateway.configura;

import org.andot.graphene.gateway.configura.security.*;
import org.andot.graphene.oauth.server.filter.JwtAuthenticationTokenFilter;
import org.andot.graphene.oauth.server.service.provider.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/***
 * @author lucas
 * @since 1.0
 */
//@Profile({"test", "prod"})
@Primary
@Order(99)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;
    @Autowired
    private SecurityLogoutSuccessHandler securityLogoutSuccessHandler;
    @Autowired
    private SecurityAuthenticationEntryPoint securityAuthenticationEntryPoint;
    @Autowired
    private SecurityAccessDeniedHandler securityAccessDeniedHandler;
    @Autowired
    private SecurityAuthenticationProviderConfig securityAuthenticationProviderConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityAuthenticationProviderConfig);
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/swagger-ui.html",
                "/swagger-resources/**",
                "/images/**",
                "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //去掉csrf
        http.csrf().disable()
                //使用JWT，关闭Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()// swagger start
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/oauth/**").permitAll()

                .and()
                .authorizeRequests()
                .anyRequest()
                // RBAC 动态 url 认证
                .access("@userLoginService.hasPermission(authentication, request)")
                .and()
                // 开启登录
                .formLogin()
                // 登录成功
                .successHandler(securityAuthenticationSuccessHandler)
                // 登录失败
                .failureHandler(securityAuthenticationFailureHandler)
                // permitAll()表示这个不需要验证 登录页面，登录失败页面
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(securityLogoutSuccessHandler)
                .permitAll()
        // 记住我
        .and().rememberMe().rememberMeParameter("remember-me").useSecureCookie(true).tokenValiditySeconds(3600)
        // 无权限的时候返回的
        .and().httpBasic().authenticationEntryPoint(securityAuthenticationEntryPoint)
        // 无权访问 JSON 格式的数据
        .and().exceptionHandling().accessDeniedHandler(securityAccessDeniedHandler);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
