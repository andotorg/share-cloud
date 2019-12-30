package org.andot.graphene.gateway.configura.security;

import org.andot.graphene.common.out.JsonWarn;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 当没有权限时，返回的结果
 * @author Andot
 * @date 2019-2-6 20:11:13
 * @since 1.0
 */
@Component
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        JsonWarn jsonWarn = new JsonWarn(null, "请联系管理员，访问地址");
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(jsonWarn.toString());
    }
}
