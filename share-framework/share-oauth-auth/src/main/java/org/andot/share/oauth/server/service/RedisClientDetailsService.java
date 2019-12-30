package org.andot.share.oauth.server.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public interface RedisClientDetailsService extends ClientDetailsService {
    @Override
    ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException;
}
