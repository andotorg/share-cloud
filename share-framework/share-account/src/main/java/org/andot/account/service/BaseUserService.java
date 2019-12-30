package org.andot.account.service;

import org.andot.account.entity.BaseUser;

import java.util.List;

/***
 * 基本用户操作服务
 * @author andot
 * @date 2019-2-15 16:43:14
 * @since 1.0
 */
public interface BaseUserService {

    /***
     * 根据主键获取基本用户信息
     * @param id
     * @return
     */
    BaseUser getBaseUserInfo(Integer id);

    /***
     * 用户登录使用接口
     * @param username  用户名
     * @param password  密码
     * @return
     */
    Integer getBaseUserId(String username, String password);

    /***
     * 判断此用户是否存在
     * @param username 用户名
     * @return
     */
    boolean getBaseUserForName(String username);

    /***
     * 根据页面id获取相应的基本用户列表
     * @param id
     * @return
     */
    List<BaseUser> getBaseUserInfoList(Integer id);

    /***
     * 根据基本用户信息查询数据信息列表
     * @param id
     * @return
     */
    List<BaseUser> getBaseUserInfoList(BaseUser id);

    /***
     * 添加基本用户
     * @param action
     * @return
     */
    Integer saveBaseUser(BaseUser action);

    /***
     * 更新基本用户
     * @param action
     */
    void updateBaseUser(BaseUser action);

    /***
     * 删除基本用户，支持多选删除
     * @param ids
     */
    void deleteBaseUser(List<Integer> ids);


}
