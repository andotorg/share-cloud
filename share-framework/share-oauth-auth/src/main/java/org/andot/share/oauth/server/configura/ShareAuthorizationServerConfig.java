package org.andot.share.oauth.server.configura;

import com.alibaba.druid.pool.DruidDataSource;
import org.andot.share.oauth.server.converter.JwtTokenEnhancer;
import org.andot.share.oauth.server.filter.ShareAuthenticationFilter;
import org.andot.share.oauth.server.service.RedisClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/****
 *
 * OAuth2 认证服务器配置
 * @author Andot
 * @date 2019-11-3 20:54:54
 * @since 1.0
 */
@Configuration
@EnableAuthorizationServer
public class ShareAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;
    @Autowired
    private JwtTokenStore jwtTokenStore;
    @Autowired
    private AuthenticationManager authenticationManagerBean;
    @Autowired
    private RedisClientDetailsService redisClientDetailsService;
    @Resource
    private UserDetailsService oauthUserDetailsService;
    @Autowired
    private WebResponseExceptionTranslator webResponseExceptionTranslator;
    @Autowired
    private ShareAuthenticationFilter shareAuthenticationFilter;
    @Autowired
    private RedisTokenStore redisTokenStore;
    @Autowired
    private DruidDataSource shareDruidDataSource;

    /***
     * 定义令牌端点上的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                .addTokenEndpointAuthenticationFilter(shareAuthenticationFilter);
    }

    /***
     * 定义授权和令牌端点以及令牌服务
     * /oauth/authorize（授权端点）
     * /oauth/token（令牌端点）
     * /oauth/confirm_access（用户在此处发布对批准的批准）
     * /oauth/error（用于在授权服务器中呈现错误）
     * /oauth/check_token（由资源服务器用于解码访问令牌）
     * /oauth/token_key（如果使用JWT令牌，则公开用于令牌验证的公钥）
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 加入jwt增强， 可以自定义加入字段
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(jwtTokenEnhancer);
        tokenEnhancers.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);
        endpoints
                .authenticationManager(authenticationManagerBean)
                .tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                .exceptionTranslator(webResponseExceptionTranslator)
                .userDetailsService(oauthUserDetailsService)
                .tokenEnhancer(tokenEnhancerChain);

    }

    /***
     * 定义客户端详细信息服务的配置程序。可以初始化客户端详细信息
     * clientId：（必填）客户端ID。
     * secret：（对于受信任的客户端是必需的）客户端密钥（如果有）。
     * scope：客户端受限制的范围。如果范围未定义或为空（默认值），则客户端不受范围的限制。
     * authorizedGrantTypes：授权客户使用的授权类型。默认值为空。
     *      client_credentials 客户端凭证模式
     *      authorization_code 授权码模式
     *      refresh_token 刷新令牌模式 (每次都要刷新)
     *      implicit 简化模式
     *      password 密码模式
     * authorities：授予客户端的权限（常规的Spring Security权限）。
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients/*.jdbc(shareDruidDataSource)
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());*/
        .withClientDetails(redisClientDetailsService);
    }
}
