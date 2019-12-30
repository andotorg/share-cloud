package org.andot.share.oauth.server.domain;

import org.springframework.stereotype.Component;

/**
 * 获取客户端的基本授权
 */
@Component
public class BaseAuthorizeClient {



    /**
     * 根据userId获取用户权限 包括资源id集合和权限id集合
     * @param userId
     * @return
     */
    /*public Authorize getAuthorize(Long userId) {
        Authorize authorize = baseUserFeignService.getAuthorize(userId);
        return authorize;
    }*/

}
