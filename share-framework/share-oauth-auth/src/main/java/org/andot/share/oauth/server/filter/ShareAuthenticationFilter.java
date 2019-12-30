package org.andot.share.oauth.server.filter;

import org.andot.share.oauth.server.domain.AuthConfigurationProperties;
import org.andot.share.oauth.server.service.ShareAuthenticatorService;
import org.andot.share.oauth.server.share.ShareAuthenticationContext;
import org.andot.share.oauth.server.share.ShareAuthentication;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 整合认证授权过滤器
 * @author Andot
 */
@Component
public class ShareAuthenticationFilter extends GenericFilterBean implements ApplicationContextAware {

    @Autowired
    private AuthConfigurationProperties authConfigurationProperties;
    /**
     * 认证类型参数名称
     */
    private static final String AUTH_TYPE_PARM_NAME = "auth_type";

    private static final String OAUTH_TOKEN_URL = "/oauth/token";

    private Collection<ShareAuthenticatorService> authenticators;

    private ApplicationContext applicationContext;

    /***
     * 请求匹配策略
     */
    private RequestMatcher requestMatcher;

    /***
     * 填充请求匹配策略 获取token的get和post方法
     */
    public ShareAuthenticationFilter() {
        this.requestMatcher = new OrRequestMatcher(
                new AntPathRequestMatcher(OAUTH_TOKEN_URL, "GET"),
                new AntPathRequestMatcher(OAUTH_TOKEN_URL, "POST")
        );
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(requestMatcher.matches(request)){
            //设置集成登录
            ShareAuthentication shareAuthentication = new ShareAuthentication();
            shareAuthentication.setAuthType(request.getParameter(AUTH_TYPE_PARM_NAME));
            shareAuthentication.setAuthParameters(request.getParameterMap());
            ShareAuthenticationContext.addHolderItem(shareAuthentication);
            try{
                this.before(shareAuthentication);

                filterChain.doFilter(request, response);

                this.affter(shareAuthentication);
            } catch (Exception e){
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                response.getWriter().write(e.getMessage());
            } finally {
                ShareAuthenticationContext.clearHolder();
            }
        }else{
            request.setAttribute("auth_type", "other");
            filterChain.doFilter(request, response);
        }
    }

    public void before(ShareAuthentication shareAuthentication) {
        //延迟加在认证器
        if(this.authenticators == null){
            synchronized (this){
                Map<String, ShareAuthenticatorService> shareAuthenticatorMap = applicationContext.getBeansOfType(ShareAuthenticatorService.class);
                if (shareAuthenticatorMap != null) {
                    this.authenticators = shareAuthenticatorMap.values();
                }
            }
        }
        if(this.authenticators == null){
            this.authenticators = new ArrayList<>();
        }
        // 判断认证类型是否存在
        if(shareAuthentication.getAuthType() == null){
            throw new InvalidRequestException("{error:\"auth_type\", error_description:\"auth_type 参数没有传\"}");
        }else{
            if(!authConfigurationProperties.getTypes().contains(shareAuthentication.getAuthType())){
                throw new InvalidRequestException("{error:\"auth_type\", error_description:\"没有找到"+shareAuthentication.getAuthType()+"的提供者为您登录操作\"}");
            }
        }
        for (ShareAuthenticatorService authenticatorService : authenticators){
            if(authenticatorService.support(shareAuthentication)){
                authenticatorService.before(shareAuthentication);
            }
        }
    }

    public void affter(ShareAuthentication shareAuthentication) {
        for (ShareAuthenticatorService authenticatorService : authenticators){
            if(authenticatorService.support(shareAuthentication)){
                authenticatorService.affter(shareAuthentication);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
