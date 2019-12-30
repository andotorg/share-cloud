package org.andot.account.configure;

import org.andot.graphene.common.out.JsonWarn;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 未授權，返回的结果
 * @author Andot
 * @date 2019-2-6 20:11:13
 * @since 1.0
 */
@Component
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonWarn jsonWarn = new JsonWarn(httpServletRequest.getRequestURI(), "此地址未授权，请联系管理员，访问地址");
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(jsonWarn.toString());
    }
}
