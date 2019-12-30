package org.andot.share.oauth.server.service.provider;

import org.andot.share.oauth.server.service.RedisClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class RedisClientDetailsServiceImpl implements RedisClientDetailsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        return null;
    }
}
