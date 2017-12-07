package com.imory.cn.admin.service.impl;

import com.imory.cn.admin.dao.AdminUserCommonMapper;
import com.imory.cn.admin.dao.AdminUserMapper;
import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.admin.dto.AdminUserExample;
import com.imory.cn.admin.service.AdminUserService;
import com.imory.cn.common.dto.WebResult;
import com.imory.cn.role.dao.UserRoleCommonMapper;
import com.imory.cn.role.dto.Role;
import com.imory.cn.userRole.dao.UserRoleMapper;
import com.imory.cn.userRole.dto.UserRoleExample;
import com.imory.cn.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 系统用户相关业务接口实现类
 * Created by Raye on 2017/3/21.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper mapper;

    @Autowired
    private AdminUserCommonMapper adminUserCommonMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserRoleCommonMapper userRoleCommonMapper;

    @Override
    public List<AdminUser> select(int page, int pageSize, String query)
    {
        return adminUserCommonMapper.select((page - 1) * pageSize, pageSize, "%" + query + "%");
    }

    @Override
    public int selectCount(String query)
    {
        AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andNameLike("%" + query + "%");
        return mapper.countByExample(adminUserExample);
    }

    @Override
    public AdminUser login(String name, String pwd)
    {
        AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andNameEqualTo(name).andPswEqualTo(MD5Util.MD5(pwd)).andFlagEqualTo(1);
        List<AdminUser> users = mapper.selectByExample(adminUserExample);
        if (users != null && users.size() > 0)
        {
            AdminUser user = users.get(0);
            adminUserCommonMapper.updateLoginTime(user);
            return user;
        }
        return null;
    }

    @Override
    public AdminUser selectById(int id)
    {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean insert(AdminUser user)
    {
        user.setPsw(MD5Util.MD5(user.getPsw()));
        return mapper.insertSelective(user) > 0;
    }

    @Override
    public boolean update(AdminUser user)
    {
        return mapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Transactional
    @Override
    public boolean delete(int id)
    {
        mapper.deleteByPrimaryKey(id);
        UserRoleExample roleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andUseridEqualTo(id);
        userRoleMapper.deleteByExample(roleExample);
        return true;
    }

    @Override
    public List<Role> selectUserRole(int id)
    {
        return userRoleCommonMapper.selectByUserId(id);
    }

    @Override
    public boolean updateRoleMenu(String ids, int userid, int creater)
    {
        if (ids.length() > 0)
        {
            ids = ids.substring(0, ids.length() - 1);
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("roleids", ids);
        map.put("creator", creater);
        map.put("userid", userid);
        userRoleCommonMapper.userRoleUpdate(map);
        return true;
    }

    @Override
    public WebResult updatePass(int userId, String psw, String oldPsw)
    {
        AdminUser user = mapper.selectByPrimaryKey(userId);
        if (user.getPsw().equalsIgnoreCase(MD5Util.MD5(oldPsw)))
        {
            user.setUpdate_user(userId);
            user.setUpdate_time(new Date());
            user.setPsw(MD5Util.MD5(psw));
            if (mapper.updateByPrimaryKeySelective(user) > 0)
            {
                return WebResult.success();
            } else
            {
                return WebResult.unKnown();
            }
        } else
        {
            return WebResult.error("旧密码错误");
        }
    }
}