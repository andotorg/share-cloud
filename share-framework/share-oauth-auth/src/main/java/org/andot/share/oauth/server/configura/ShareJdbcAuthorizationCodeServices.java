package org.andot.share.oauth.server.configura;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;

import javax.sql.DataSource;

/**
 * 重写code实现的长度
 * @author Andot
 */
public class ShareJdbcAuthorizationCodeServices extends JdbcAuthorizationCodeServices {

    private RandomValueStringGenerator generator;

    public ShareJdbcAuthorizationCodeServices(DataSource dataSource) {
        super(dataSource);
        this.generator = new RandomValueStringGenerator(16);
    }

    @Override
    public String createAuthorizationCode(OAuth2Authentication auth2Authentication){
        String code = this.generator.generate();
        store(code, auth2Authentication);
        return code;
    }

}
