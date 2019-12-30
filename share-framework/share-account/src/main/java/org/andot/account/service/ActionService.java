package org.andot.account.service;

import org.andot.account.entity.Action;
import org.andot.account.vo.in.InActionVo;
import org.andot.account.vo.out.OutActionVo;

import java.util.List;

/***
 * 数据地址操作服务
 * @author andot
 * @date 2019年1月11日17:34:07
 * @since 1.0
 */
public interface ActionService {

    /***
     * 根据主键获取地址信息
     * @param id
     * @return
     */
    Action getActionInfo(Integer id);

    /***
     * 根据页面id获取相应的数据地址列表
     * @param id
     * @return
     */
    List<Action> getActionInfoList(Integer id);

    /***
     * 根据数据地址信息查询数据信息列表
     * @param inActionVo
     * @return
     */
    List<OutActionVo> getActionInfoList(InActionVo inActionVo);

    /***
     * 添加数据地址
     * @param action
     * @return
     */
    Integer saveAction(Action action);

    /***
     * 更新数据地址
     * @param action
     */
    void updateAction(Action action);

    /***
     * 删除数据地址，支持多选删除
     * @param ids
     */
    void deleteAction(List<Integer> ids);


}
