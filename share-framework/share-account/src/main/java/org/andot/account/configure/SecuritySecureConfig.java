package org.andot.account.configure;

import org.andot.account.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/***
 * @author lucas
 * @since 1.0
 */
//@Profile({"test", "prod"})
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

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
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private SecurityAuthenticationProviderConfig securityAuthenticationProviderConfig;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityAuthenticationProviderConfig);
        //auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //去掉csrf
        http.csrf().disable()
                //使用JWT，关闭Token
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .httpBasic().authenticationEntryPoint(securityAuthenticationEntryPoint)

                .and()
                .authorizeRequests()// swagger start
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/user/**").permitAll()

                .and()
                .authorizeRequests()
                .anyRequest()
                // RBAC 动态 url 认证
                .access("@userLoginService.hasPermission(authentication, request)")

                .and()
                //开启登录
                .formLogin()
                // 登录成功
                .successHandler(securityAuthenticationSuccessHandler)
                // 登录失败
                .failureHandler(securityAuthenticationFailureHandler)
                //permitAll()表示这个不需要验证 登录页面，登录失败页面
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(securityLogoutSuccessHandler)
                .permitAll();
        // 记住我
        http.rememberMe().rememberMeParameter("remember-me").useSecureCookie(true).tokenValiditySeconds(3600);
        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(securityAccessDeniedHandler);
        // JWT Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
