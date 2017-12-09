package com.imory.cn.userRole.service;

import com.imory.cn.userRole.dto.UserRole;

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
public interface UserRoleService {

    List<UserRole> getUserRoleByUserId(Integer userId);

    boolean updateUserRole(UserRole userRole);

    boolean saveUserRole(UserRole userRole);
}
