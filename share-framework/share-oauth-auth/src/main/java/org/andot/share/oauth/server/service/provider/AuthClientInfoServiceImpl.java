package org.andot.share.oauth.server.service.provider;

import org.andot.share.oauth.server.domain.AuthClientInfo;
import org.andot.share.oauth.server.service.AuthClientInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@CacheConfig(cacheNames = "auth")
@Service
public class AuthClientInfoServiceImpl implements AuthClientInfoService {

    @Resource
    private RedisTemplate redisTemplate;

    @Cacheable(key = "#key")
    @Override
    public AuthClientInfo getValueByKey(String key){
        redisTemplate.opsForValue().get(key);
        return new AuthClientInfo();
    }
}
