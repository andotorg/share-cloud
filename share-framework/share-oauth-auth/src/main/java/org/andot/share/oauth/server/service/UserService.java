package org.andot.share.oauth.server.service;

public interface UserService {
    /***
     * 根据用户名查询此用户是否存在
     * @param username
     * @return
     */
    boolean getBaseUserForName(String username);

    /***
     * <p>数据库中查询用户名密码是否正确，查询到记录返回<code>UserId</code></p>
     * @param username
     * @param password
     * @return
     */
    Integer getBaseUserId(String username, String password);
}
