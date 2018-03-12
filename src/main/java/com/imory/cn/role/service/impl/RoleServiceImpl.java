package com.imory.cn.role.service.impl;

import com.imory.cn.role.dao.RoleMapper;
import com.imory.cn.role.dto.Role;
import com.imory.cn.role.dto.RoleExample;
import com.imory.cn.role.service.RoleService;
import org.apache.commons.lang.StringUtils;
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
 * @Date 2017/12/7
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 角色列表
     *
     * @param startPos
     * @param pageSize
     * @param name
     * @return
     */
    @Override
    public List<Role> listRole(int startPos, int pageSize, String name, Integer userId)
    {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (StringUtils.isNotBlank(name))
        {
            criteria.andNameLike("%" + name + "%");
        }
        if (userId != -1)
        {
            criteria.andCreatorEqualTo(userId);
        }
        roleExample.setOrderByClause("create_time desc" + " limit " + startPos + "," + pageSize);

        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public int countRole(String name, Integer userId)
    {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (StringUtils.isNotBlank(name))
        {
            criteria.andNameLike(name);
        }
        if (userId != -1)
        {
            criteria.andCreatorEqualTo(userId);
        }
        return roleMapper.countByExample(roleExample);
    }

    @Override
    public boolean insert(Role role)
    {
        return roleMapper.insertSelective(role) > 0;
    }

    @Override
    public Role selectById(Integer id)
    {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Role role)
    {
        return roleMapper.updateByPrimaryKey(role) > 0;
    }

    @Override
    public List<Role> listRoleByUserId(Integer userId)
    {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andCreatorEqualTo(userId);
        return roleMapper.selectByExample(roleExample);
    }
}
