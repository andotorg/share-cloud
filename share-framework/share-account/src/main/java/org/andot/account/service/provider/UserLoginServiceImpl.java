package org.andot.account.service.provider;

import org.andot.account.domain.UniSafeUserDetails;
import org.andot.account.mapper.BaseUserMapper;
import org.andot.account.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private BaseUserMapper baseUserDao;

    @Override
    public Integer loginVlid(String username, String password) {
        return null;
    }

    @Override
    public UniSafeUserDetails getUserSessionInfo(Integer userId) {
        UniSafeUserDetails userInfo = baseUserDao.getUserDetails(userId);
        return userInfo;
    }

    @Override
    public boolean hasPermission(Authentication authentication, HttpServletRequest request) {
        Object userInfo = authentication.getPrincipal();
        boolean hasPermission  = false;

        //获取资源

        Set<String> urls = new HashSet();
        urls.add("/action/list"); // 这些 url 都是要登录后才能访问，且其他的 url 都不能访问

        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (userInfo instanceof UniSafeUserDetails) {
            long id = ((UniSafeUserDetails) userInfo).getUserId();

            Set set2 = new HashSet();
            Set set3 = new HashSet();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
            return hasPermission;
        } else {
            return false;
        }
    }
}
