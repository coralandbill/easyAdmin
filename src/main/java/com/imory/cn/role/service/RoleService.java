package com.imory.cn.role.service;

import com.imory.cn.role.dto.Role;

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
public interface RoleService {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> listRole(int startPos, int pageSize, String name, Integer userId);

    /**
     * 查询角色数目
     * @param name
     * @return
     */
    int countRole(String name);

    boolean insert(Role role);

    Role selectById(Integer id);

    boolean update(Role role);

    List<Role> listRoleByUserId(Integer userId);
}
