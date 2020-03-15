package org.andot.graphene.gateway.configura.security;

import org.andot.graphene.common.out.JsonFail;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****
 * 认证失败的时候，返回的结果
 * @author lucas
 */
@Component
public class SecurityAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        JsonFail jsonWarn = new JsonFail(null, "登录失败，具体原因："+e.getMessage());
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(jsonWarn.toString());
    }
}
