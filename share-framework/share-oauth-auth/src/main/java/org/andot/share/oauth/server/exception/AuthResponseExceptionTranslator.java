package org.andot.share.oauth.server.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.UnsupportedResponseTypeException;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        log.error("translate:"+e.getMessage());
        e.printStackTrace();
        OAuth2Exception oAuth2Exception;
        if(e.getMessage() != null){
            oAuth2Exception = new InvalidGrantException("用户名密码错误", e);
        }else if(e instanceof InternalAuthenticationServiceException){
            oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
        }else{
            oAuth2Exception = new UnsupportedResponseTypeException("服务器内部错误", e);
        }
        return super.translate(oAuth2Exception);
    }
}
