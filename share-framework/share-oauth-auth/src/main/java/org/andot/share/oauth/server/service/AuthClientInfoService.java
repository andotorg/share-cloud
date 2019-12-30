package org.andot.share.oauth.server.service;

import org.andot.share.oauth.server.domain.AuthClientInfo;

public interface AuthClientInfoService {
    AuthClientInfo getValueByKey(String key);
}
