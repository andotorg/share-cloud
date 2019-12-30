package org.andot.graphene.gateway.configura.security;

import org.andot.graphene.common.out.JsonSuccess;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 退出登录成功之后返回Token
 */
@Component
public class SecurityLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JsonSuccess jsonSuccess = new JsonSuccess(null, "退出登录");
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(jsonSuccess.toString());
    }
}
