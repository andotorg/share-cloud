package org.andot.share.oauth.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OauthAuthorizationApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ValueOperations valueOperations;

    @Test
    public void redisDemo(){
        valueOperations.set("name", "lucas");
    }
}
