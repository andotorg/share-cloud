package org.andot.share.oauth.server.service;

import org.andot.share.oauth.server.domain.BaseUserAuthentication;
import org.andot.share.oauth.server.share.ShareAuthentication;

/**
 * 分享认证器服务, 执行各自认证实现
 * @author Andot
 */
public interface ShareAuthenticatorService {
    /**
     * 处理分享认证
     * @param shareAuthentication
     * @return
     */
    BaseUserAuthentication authenticate(ShareAuthentication shareAuthentication);

    /***
     * 认证开始前执行
     * @param shareAuthentication
     */
    void before(ShareAuthentication shareAuthentication);

    /**
     * 查看根据类型找到实现类，查看是否支持此种类型的认证
     * @param shareAuthentication
     */
    boolean support(ShareAuthentication shareAuthentication);

    /***
     * 认证结束后执行
     * @param shareAuthentication
     */
    void affter(ShareAuthentication shareAuthentication);
}
