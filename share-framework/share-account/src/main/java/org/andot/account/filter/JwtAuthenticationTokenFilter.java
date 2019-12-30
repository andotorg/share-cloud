package org.andot.account.filter;

import org.andot.account.domain.UniSafeUserDetails;
import org.andot.account.service.UserLoginService;
import org.andot.graphene.common.utils.JWTTokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/***
 * @author lucas
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private UserLoginService userLoginService;
    private final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith(this.BEARER)) {
            final String authToken = authHeader.substring(this.BEARER.length());

            String id = null;
            try {
                id = JWTTokenUtil.parseToken(authToken, "lucas");
            } catch (TimeoutException e) {
                e.printStackTrace();
                throw new ServletException(e.getMessage());
            }

            Integer userId = Integer.parseInt(id);
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UniSafeUserDetails userDetails = userLoginService.getUserSessionInfo(userId);

                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
