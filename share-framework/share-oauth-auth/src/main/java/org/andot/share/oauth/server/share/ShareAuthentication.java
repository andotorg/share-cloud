package org.andot.share.oauth.server.share;

import lombok.Data;

import java.util.Map;

/***
 * 分享认证实体类， 整合多种登录方式的基类
 * @author Andot
 */
@Data
public class ShareAuthentication {
    private String authType;
    private String username;
    private Map<String, String[]> authParameters;

    public String getAuthParameters(String paramster) {
        String[] values = this.authParameters.get(paramster);
        if(values != null && values.length>0){
            return values[0];
        }
        return null;
    }
}
