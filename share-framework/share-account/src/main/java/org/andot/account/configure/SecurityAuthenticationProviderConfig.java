package org.andot.account.configure;

import org.andot.account.domain.UniSafeUserDetails;
import org.andot.account.service.BaseUserService;
import org.andot.account.service.provider.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.NoSuchElementException;

@Component
public class SecurityAuthenticationProviderConfig implements AuthenticationProvider {

    @Autowired
    private UserDetailsServiceImpl securityUserDetailsService;
    @Resource
    private BaseUserService baseUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        String username = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();//
        // TODO 通过用户名取出用户信息，然后比对密码，如果取出来为空则不存在此用户，如果取出来密码不对则登录失败，如果成功则登陆成功

        boolean isUsername = baseUserService.getBaseUserForName(username);
        if(!isUsername){
            throw new NoSuchElementException("该用户不存在！");
        }
        Integer userId = baseUserService.getBaseUserId(username, password);
        if(StringUtils.isEmpty(userId)){
            throw new AuthenticationServiceException("密码或用户名不正确！");
        }
        UniSafeUserDetails userInfo = (UniSafeUserDetails)securityUserDetailsService.loadUserByUsername(userId.toString());
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();

        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // 这里直接改成retrun true;表示是支持这个执行
        return true;
    }
}
