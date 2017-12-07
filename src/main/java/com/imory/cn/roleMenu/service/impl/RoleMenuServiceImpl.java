package com.imory.cn.roleMenu.service.impl;

import com.imory.cn.menu.dto.Menu;
import com.imory.cn.roleMenu.dao.RoleMenuCommonMapper;
import com.imory.cn.roleMenu.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuCommonMapper roleMenuCommonMapper;

    @Override
    public List<Menu> listMenuByRoleId(int id) {
        HashMap<Integer, ArrayList<Menu>> map = new HashMap<Integer, ArrayList<Menu>>();
        List<Menu> menus = roleMenuCommonMapper.listMenuByRoleId(id);
        for (Menu menu : menus) {
            if(menu.getRoleId() != null)
            {
                menu.setChecked(Boolean.TRUE);
                //menu.setEnable(Boolean.FALSE);
            }
            int parentid = menu.getParent_id();
            if (menu.getRoleId() != null) {
                menu.setAdditionalParameters(new HashMap<String, Object>());
                menu.getAdditionalParameters().put("item-selected", true);
            }
            if (map.containsKey(parentid)) {
                map.get(parentid).add(menu);
            } else {
                ArrayList<Menu> temp = new ArrayList<Menu>();
                temp.add(menu);
                map.put(parentid, temp);
            }
        }
        for (Menu menu : menus) {
            int mid = menu.getId();
            if (map.containsKey(mid)) {
                menu.setMenu_type("folder");
                menu.setChildren(map.get(mid));
            } else {
                menu.setMenu_type("item");
            }
        }
        return map.get(0);
    }

    @Override
    public boolean updateRoleMenu(String ids, int roleid, int userid) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("menuids", ids);
        map.put("roleid", roleid);
        map.put("userid", userid);
        roleMenuCommonMapper.roleMenuUpdate(map);
        return true;
    }
}
