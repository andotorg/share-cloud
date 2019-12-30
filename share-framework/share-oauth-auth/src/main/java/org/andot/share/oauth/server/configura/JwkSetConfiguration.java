package org.andot.share.oauth.server.configura;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;

/**
 * @author Andot
 */
@Import(AuthorizationServerEndpointsConfiguration.class)
@Configuration
public class JwkSetConfiguration extends AuthorizationServerConfigurerAdapter {

    // ... the rest of the configuration from the previous section
}
