package com.imory.cn.role.controller;

import com.google.gson.Gson;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.menu.dto.Menu;
import com.imory.cn.roleMenu.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
@Controller
@RequestMapping("admin/role")
public class RoleController {

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model)
    {
        return "role/role";
    }

    @RequestMapping("/menu")
    @SessionCheck
    public String roleMenu(Integer roleId, Model model)
    {
        List<Menu> menuList = roleMenuService.listMenuByRoleId(roleId);
        List<Integer> roleIdList = new ArrayList<>();
        for (Menu menu : menuList)
        {
            if (menu.getRoleId() != null)
            {
                roleIdList.add(menu.getRoleId());
            }
        }
        model.addAttribute("menu", new Gson().toJson(menuList));
        model.addAttribute("roleIdList", roleIdList);
        model.addAttribute("roleId", roleId);
        return "role/roleMenu";
    }
}
