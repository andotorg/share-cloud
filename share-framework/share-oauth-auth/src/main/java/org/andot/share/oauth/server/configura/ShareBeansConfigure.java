package org.andot.share.oauth.server.configura;

import com.alibaba.druid.pool.DruidDataSource;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.andot.share.oauth.server.converter.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Date;

/**
 * @author Andot
 */
@Configuration
public class ShareBeansConfigure {

    @Autowired
    private KeyPair keyPair;
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new ShareJdbcAuthorizationCodeServices(druidDataSource);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //jwtAccessTokenConverter.setSigningKey("lucas");
        jwtAccessTokenConverter.setKeyPair(keyPair);
        return jwtAccessTokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public RedisTokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer(){
        return new JwtTokenEnhancer();
    }

    @Bean
    public KeyPair keyPair() {
        try {
            // 寻找证书文件
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks");
            // java key store 固定常量
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, "123456".toCharArray());
            // jwt 为 命令生成整数文件时的别名
            PrivateKey privateKey = (PrivateKey) keyStore.getKey("andot", "123456".toCharArray());
            PublicKey publicKey = keyStore.getCertificate("andot").getPublicKey();
            return new KeyPair(publicKey, privateKey);
        } catch ( Exception e ) {
            throw new IllegalArgumentException(e);
        }
    }

    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator(){
        return new DefaultWebResponseExceptionTranslator(){
            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
                OAuth2Exception body = responseEntity.getBody();
                HttpHeaders headers = new HttpHeaders();
                headers.setAll(responseEntity.getHeaders().toSingleValueMap());
                return new ResponseEntity<>(body, headers, responseEntity.getStatusCode());
            }
        };
    }

    @Primary
    @Bean
    public ClientDetailsService consumerClientDetailsService(){
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(this.druidDataSource);
        clientDetailsService.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        return clientDetailsService;
    }
}
