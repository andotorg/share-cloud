package org.andot.account.service;

import org.andot.account.entity.Role;

import java.util.List;

/***
 * 角色接口服务
 */
public interface RoleService {

    /***
     * 添加角色
     * @param role
     */
    void addRole(Role role);

    /***
     * 更新角色
     * @param role
     */
    void updateRole(Role role);

    /***
     * 删除角色
     * @param role
     */
    void deleteRole(Role role);


    /***
     * 根据id获取角色
     * @param id
     * @return
     */
    Role getRole(Integer id);

    /***
     * 获取角色列表
     * @param role
     * @return
     */
    List<Role> getRoleList(Role role);
}
