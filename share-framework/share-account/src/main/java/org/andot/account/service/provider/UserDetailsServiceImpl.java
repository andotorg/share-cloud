package org.andot.account.service.provider;

import org.andot.account.domain.UniSafeUserDetails;
import org.andot.account.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("securityUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BaseUserMapper baseUserDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            throw new UsernameNotFoundException("必须为用户id");
        }
        UniSafeUserDetails userInfo = baseUserDao.getUserDetails(Integer.parseInt(s));
        if (StringUtils.isEmpty(userInfo)){
            throw new UsernameNotFoundException("用戶角色未配置");
        }
        return userInfo;
    }
}
