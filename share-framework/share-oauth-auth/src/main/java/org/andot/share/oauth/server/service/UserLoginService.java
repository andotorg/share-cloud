package org.andot.share.oauth.server.service;

import org.andot.share.oauth.server.domain.UniSafeUserDetails;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/***
 * 用户登录处理服务
 */
public interface UserLoginService {

    /***
     * 用户名和密码进行登录验证，并且返回用户唯一id
     * @param username
     * @param password
     * @return
     */
    Integer loginVlid(String username, String password);

    /***
     * 根据userid获取到相应的存储的系统之间认证的需要用户信息
     * @param userId
     * @return
     */
    UniSafeUserDetails getUserSessionInfo(Integer userId);

    boolean hasPermission(Authentication authentication, HttpServletRequest request);
}
