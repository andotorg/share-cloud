package org.andot.share.oauth.server.service.provider;

import lombok.extern.slf4j.Slf4j;
import org.andot.share.oauth.server.domain.BaseUserAuthentication;
import org.andot.share.oauth.server.service.ShareAuthenticatorService;
import org.andot.share.oauth.server.share.ShareAuthentication;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class UsernamePasswordAuthenticator implements ShareAuthenticatorService {

    private static final String AUTH_TYPE_VALUE = "base";

    @Override
    public BaseUserAuthentication authenticate(ShareAuthentication shareAuthentication) {
        log.debug("根据用户名获取用户信息");
        BaseUserAuthentication baseUserAuthentication = new BaseUserAuthentication();
        baseUserAuthentication.setId(1L);
        baseUserAuthentication.setName("root");
        baseUserAuthentication.setPassword(new BCryptPasswordEncoder().encode("123"));
        return baseUserAuthentication;
    }

    @Override
    public void before(ShareAuthentication shareAuthentication) {

        log.debug("用户名密码登录进入before===验证用户名和密码是否正确");
    }

    @Override
    public boolean support(ShareAuthentication shareAuthentication) {
        return AUTH_TYPE_VALUE.equals(shareAuthentication.getAuthType());
    }

    @Override
    public void affter(ShareAuthentication shareAuthentication) {
        log.debug("用户名密码登录进入affter");

    }
}
