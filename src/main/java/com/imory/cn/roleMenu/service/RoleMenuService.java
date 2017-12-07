package com.imory.cn.roleMenu.service;

import com.imory.cn.menu.dto.Menu;

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
public interface RoleMenuService {
    /**
     * 查询角色的相关资源权限（菜单权限）
     *
     * @param id
     * @return
     */
    List<Menu> listMenuByRoleId(int id);

    /**
     * 更新角色权限
     * @param ids
     * @return
     */
    boolean updateRoleMenu(String ids, int roleid, int userid);
}
