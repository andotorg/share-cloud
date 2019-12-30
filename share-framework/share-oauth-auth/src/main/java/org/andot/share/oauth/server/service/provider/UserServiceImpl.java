package org.andot.share.oauth.server.service.provider;

import org.andot.share.oauth.server.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean getBaseUserForName(String username) {
        return true;
    }

    @Override
    public Integer getBaseUserId(String username, String password) {
        return 1;
    }
}
