package org.andot.share.oauth.server.service.provider;

import org.andot.graphene.common.domain.Authorize;
import org.andot.share.oauth.server.client.BaseUserFeignService;
import org.andot.share.oauth.server.service.ShareAuthenticatorService;
import org.andot.share.oauth.server.share.ShareAuthentication;
import org.andot.share.oauth.server.share.ShareAuthenticationContext;
import org.andot.share.oauth.server.domain.BaseAuthorizeClient;
import org.andot.share.oauth.server.domain.BaseUserAuthentication;
import org.andot.share.oauth.server.domain.UniSafeUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Spring Security 用户服务接口实现
 * @author Andot
 */
@Service("oauthUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BaseAuthorizeClient baseAuthorizeClient;
    @Autowired
    private BaseUserFeignService baseUserFeignService;

    private List<ShareAuthenticatorService> authenticatorServices;

    private static final String AUTH_OTHER = "other";

    @Autowired(required = false)
    public void setAuthenticatorServices(List<ShareAuthenticatorService> authenticatorServices) {
        this.authenticatorServices = authenticatorServices;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ShareAuthentication shareAuthentication = ShareAuthenticationContext.getHolderItem();
        if(shareAuthentication == null){
            shareAuthentication = new ShareAuthentication();
            shareAuthentication.setAuthType(AUTH_OTHER);
        }
        shareAuthentication.setUsername(username);
        BaseUserAuthentication baseUserAuthentication = this.authenticate(shareAuthentication);
        if(baseUserAuthentication == null){
            throw new UsernameNotFoundException("此用户不存在");
        }
        // 把用户信息放入spring security 进行判断
        UniSafeUserDetails uniSafeUserDetails = new UniSafeUserDetails();
        uniSafeUserDetails.setUserId(1L);
        BeanUtils.copyProperties(baseUserAuthentication, uniSafeUserDetails);

        this.setAuthorize(uniSafeUserDetails);
        return uniSafeUserDetails;
    }

    /**
     * 设置授权信息
     * 使用用户id查询出用的权限来并放入用户信息中
     * @param uniSafeUserDetails
     */
    public void setAuthorize(UniSafeUserDetails uniSafeUserDetails) {
        Authorize authorize = this.baseUserFeignService.getAuthorize(uniSafeUserDetails.getUserId());
        uniSafeUserDetails.setRoles(authorize.getRoles());
        uniSafeUserDetails.setResources(authorize.getResources());
    }

    /**
     * 判断此类型是否支持
     * @param shareAuthentication
     * @return
     */
    private BaseUserAuthentication authenticate(ShareAuthentication shareAuthentication) {
        if (this.authenticatorServices != null) {
            for (ShareAuthenticatorService authenticator : authenticatorServices) {
                if (authenticator.support(shareAuthentication) || AUTH_OTHER.equals(shareAuthentication.getAuthType())) {
                    return authenticator.authenticate(shareAuthentication);
                }
            }
        }
        return null;
    }
}
