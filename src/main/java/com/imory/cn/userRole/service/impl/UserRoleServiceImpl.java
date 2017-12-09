package com.imory.cn.userRole.service.impl;

import com.imory.cn.userRole.dao.UserRoleMapper;
import com.imory.cn.userRole.dto.UserRole;
import com.imory.cn.userRole.dto.UserRoleExample;
import com.imory.cn.userRole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/9
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> getUserRoleByUserId(Integer userId)
    {
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria1 = userRoleExample.createCriteria();
        criteria1.andUseridEqualTo(userId);
        List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
        return userRoleList;
    }

    @Override
    public boolean updateUserRole(UserRole userRole)
    {
        return userRoleMapper.updateByPrimaryKey(userRole) > 0;
    }

    @Override
    public boolean saveUserRole(UserRole userRole)
    {
        return userRoleMapper.insert(userRole) > 0;
    }
}
