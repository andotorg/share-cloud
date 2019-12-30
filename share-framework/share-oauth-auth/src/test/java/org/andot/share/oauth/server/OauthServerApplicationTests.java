package org.andot.share.oauth.server;

import org.andot.share.oauth.server.service.AuthClientInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OauthAuthorizationApplication.class)
public class OauthServerApplicationTests {

    @Autowired
    private AuthClientInfoService authClientInfoService;

    @Test
    public void contextLoads() {
        System.err.println(authClientInfoService.getValueByKey("test"));
    }

}
