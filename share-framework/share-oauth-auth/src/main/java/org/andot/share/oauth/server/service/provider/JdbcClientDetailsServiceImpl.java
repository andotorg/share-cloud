package org.andot.share.oauth.server.service.provider;

import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author Andot
 */
@Service
public class JdbcClientDetailsServiceImpl extends JdbcClientDetailsService {
    public JdbcClientDetailsServiceImpl(DataSource dataSource) {
        super(dataSource);
    }
}
