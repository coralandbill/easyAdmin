package com.imory.cn.menu.service.impl;

import com.imory.cn.menu.dao.MenuCommonMapper;
import com.imory.cn.menu.dao.MenuMapper;
import com.imory.cn.menu.dto.Menu;
import com.imory.cn.menu.dto.MenuExample;
import com.imory.cn.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 菜单相关数据库业务接口实现类
 *
 * @author Raye
 * @since 2016年12月1日17:36:00
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;

    @Autowired
    private MenuCommonMapper menuCommonMapper;

    public List<Menu> selectAll()
    {
        HashMap<Integer, ArrayList<Menu>> map = new HashMap<Integer, ArrayList<Menu>>();
        List<Menu> menus = menuCommonMapper.selectAll();
        for (Menu menu : menus)
        {
            int parentid = menu.getParent_id();
            if (map.containsKey(parentid))
            {
                map.get(parentid).add(menu);
            } else
            {
                ArrayList<Menu> temp = new ArrayList<Menu>();
                temp.add(menu);
                map.put(menu.getParent_id(), temp);
            }
        }
        for (Menu menu : menus)
        {
            int id = menu.getId();
            if (map.containsKey(id))
            {
                menu.setMenu_type("folder");
                menu.setChildren(map.get(id));
            } else
            {
                menu.setMenu_type("item");
            }
        }
        return map.get(0);
    }

    @Override
    public List<Menu> selectByUser(int userId)
    {
        HashMap<Integer, ArrayList<Menu>> map = new HashMap<Integer, ArrayList<Menu>>();
        List<Menu> tempMenus = null;
        if (userId == -1)
        {
            MenuExample menuExample = new MenuExample();
            MenuExample.Criteria criteria = menuExample.createCriteria();
            criteria.andStatusEqualTo("1").andMenu_typeNotEqualTo("2");
            tempMenus = mapper.selectByExample(menuExample);
        } else
        {
            tempMenus = menuCommonMapper.listMenuByUserId(userId);
        }
        for (Menu menu : tempMenus)
        {
            int parentid = menu.getParent_id();
            if (map.containsKey(parentid))
            {
                map.get(parentid).add(menu);
            } else
            {
                ArrayList<Menu> temp = new ArrayList<Menu>();
                temp.add(menu);
                map.put(menu.getParent_id(), temp);
            }
        }
        for (Menu menu : tempMenus)
        {
            int id = menu.getId();
            if (map.containsKey(id))
            {
                menu.setMenu_type("folder");
                menu.setChildren(map.get(id));
            } else
            {
                menu.setMenu_type("item");
            }
        }
        return map.get(0);
    }

    @Override
    public List<String> selectAuthorities(int userId)
    {
        if (userId == -1)
        {
            return menuCommonMapper.selectAuthoritiesByRoot();
        }
        return menuCommonMapper.selectAuthorities(userId);
    }

    public boolean addMenu(Menu menu)
    {
        return mapper.insertSelective(menu) > 0;
    }

    @Override
    public boolean updateMenu(Menu menu)
    {
        return mapper.updateByPrimaryKeySelective(menu) > 0;
    }

    @Override
    @Transactional
    public boolean delete(int id)
    {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("menuid", id);
        menuCommonMapper.deleteMenuById(map);
        return true;
    }

}
