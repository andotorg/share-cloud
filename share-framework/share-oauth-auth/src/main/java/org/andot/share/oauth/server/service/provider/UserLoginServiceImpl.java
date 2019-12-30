package org.andot.share.oauth.server.service.provider;

import org.andot.share.oauth.server.domain.UniSafeUserDetails;
import org.andot.share.oauth.server.service.UserLoginService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

/*    @Autowired
    private BaseUserMapper baseUserDao;*/

    @Override
    public Integer loginVlid(String username, String password) {
        return null;
    }

    @Override
    public UniSafeUserDetails getUserSessionInfo(Integer userId) {
        UniSafeUserDetails uniSafeUserDetails = new UniSafeUserDetails();  //baseUserDao.getUserDetails(userId);
        uniSafeUserDetails.setUsername("root");
        uniSafeUserDetails.setPassword("1234");
        uniSafeUserDetails.setUserId(1L);
        return uniSafeUserDetails;
    }

    @Override
    public boolean hasPermission(Authentication authentication, HttpServletRequest request) {
        Object userInfo = authentication.getPrincipal();
        boolean hasPermission  = false;

        //获取资源

        Set<String> urls = new HashSet();
        // 这些 url 都是要登录后才能访问，且其他的 url 都不能访问
        urls.add("/action/list");
        return true;
        /*AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (userInfo instanceof UniSafeUserDetails) {
            int id = ((UniSafeUserDetails) userInfo).getUserId();

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
        }*/
    }
}
