package org.andot.graphene.gateway.configura.security;

import org.andot.graphene.common.out.JsonSuccess;
import org.andot.graphene.common.utils.JWTTokenUtil;
import org.andot.graphene.oauth.server.domain.UniSafeUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 登录成功之后返回Token
 */
@Component
public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UniSafeUserDetails uniSafeUserDetails = (UniSafeUserDetails)authentication.getPrincipal();
        String token = JWTTokenUtil.generateToken(uniSafeUserDetails.getUserId(), 3600, "_secret");
        JsonSuccess jsonSuccess = new JsonSuccess(token, "登录");
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(jsonSuccess.toString());
    }
}
