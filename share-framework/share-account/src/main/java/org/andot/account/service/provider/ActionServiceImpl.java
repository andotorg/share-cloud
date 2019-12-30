package org.andot.account.service.provider;

import org.andot.account.entity.Action;
import org.andot.account.entity.ActionCriteria;
import org.andot.account.mapper.ActionMapper;
import org.andot.account.service.ActionService;
import org.andot.account.vo.in.InActionVo;
import org.andot.account.vo.out.OutActionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * @author lucas
 * @see ActionService
 */
@Service("actionService")
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionMapper actionDao;

    @Override
    public Action getActionInfo(Integer id) {
        return actionDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Action> getActionInfoList(Integer id) {
        ActionCriteria actionCriteria = new ActionCriteria();
        ActionCriteria.Criteria criteria = actionCriteria.createCriteria();
        criteria.andMenuIdEqualTo(id);
        return actionDao.selectByExample(actionCriteria);
    }

    @Override
    public List<OutActionVo> getActionInfoList(InActionVo actionVo) {
        ActionCriteria actionCriteria = new ActionCriteria();
        ActionCriteria.Criteria criteria = actionCriteria.createCriteria();
        criteria.andActionNameLike("'%"+actionVo.getActionName()+"'%");
        if(!StringUtils.isEmpty(actionVo.getActionType())){
            criteria.andActionTypeEqualTo(actionVo.getActionType());
        }
        if(!StringUtils.isEmpty(actionVo.getActionUrl())){
            criteria.andActionUrlLike("'%"+actionVo.getActionUrl()+"'%");
        }
        if(!StringUtils.isEmpty(actionVo.getMenuId())){
            criteria.andMenuIdEqualTo(actionVo.getMenuId());
        }

        List<OutActionVo> list = new ArrayList<>();
        List<Action> sourceList = actionDao.selectByExample(actionCriteria);
        BeanUtils.copyProperties(sourceList, list);
        return list;
    }

    @Transactional(
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class,
            timeout = 6000
    )
    @Override
    public Integer saveAction(Action action) {
        byte del = 1;
        action.setDisabled(del);
        return actionDao.insert(action);
    }

    @Transactional(
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class,
            timeout = 6000
    )
    @Override
    public void updateAction(Action action) {
        actionDao.updateByPrimaryKeySelective(action);
    }

    @Transactional(
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class,
            timeout = 6000
    )
    @Override
    public void deleteAction(List<Integer> ids) {
        for (Integer id: ids) {
            Action action = new Action();
            action.setActionId(id);
            byte del = 0;
            action.setDisabled(del);
            actionDao.updateByPrimaryKeySelective(action);
        }
    }
}
