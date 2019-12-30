package org.andot.account.service.provider;

import org.andot.account.entity.BaseUser;
import org.andot.account.entity.BaseUserCriteria;
import org.andot.account.mapper.BaseUserMapper;
import org.andot.account.service.BaseUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 方法注释 @see BaseUserService
 */
@Service("baseUserService")
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserMapper baseUserDao;

    @Override
    public BaseUser getBaseUserInfo(Integer id) {
        return baseUserDao.selectByPrimaryKey(id);
    }

    @Override
    public List<BaseUser> getBaseUserInfoList(Integer id) {
        BaseUserCriteria userCriteria = new BaseUserCriteria();
        return baseUserDao.selectByExample(userCriteria);
    }

    @Override
    public List<BaseUser> getBaseUserInfoList(BaseUser user) {
        BaseUserCriteria userCriteria = new BaseUserCriteria();
        return baseUserDao.selectByExample(userCriteria);
    }

    @Override
    public Integer getBaseUserId(String username, String password) {
        BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
        BaseUserCriteria.Criteria criteria = baseUserCriteria.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<BaseUser> baseUserList = baseUserDao.selectByExample(baseUserCriteria);
        if(CollectionUtils.isNotEmpty(baseUserList)){
            return baseUserList.get(0).getUserId();
        }
        return null;
    }

    @Override
    public boolean getBaseUserForName(String username) {
        BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
        BaseUserCriteria.Criteria criteria = baseUserCriteria.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<BaseUser> baseUserList = baseUserDao.selectByExample(baseUserCriteria);
        if(CollectionUtils.isNotEmpty(baseUserList)){
            return true;
        }
        return false;
    }

    @Override
    public Integer saveBaseUser(BaseUser user) {
        byte del = 1;
        user.setDisabled(del);
        return baseUserDao.insert(user);
    }

    @Override
    public void updateBaseUser(BaseUser user) {
        baseUserDao.updateByPrimaryKey(user);
    }

    @Override
    public void deleteBaseUser(List<Integer> ids) {
        int size = ids.size();
        for (int i = 0; i < size; i++) {
            baseUserDao.deleteByPrimaryKey(ids.get(i));
        }
    }
}
