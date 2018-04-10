package com.imory.cn.common.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.admin.service.AdminUserService;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.menu.dto.Menu;
import com.imory.cn.menu.service.MenuService;
import com.imory.cn.role.dto.Role;
import com.imory.cn.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/9/30
 */
@Controller
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model, HttpSession session) {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        List<Menu> menuList = menuService.selectByUser(adminUser.getId());
        model.addAttribute("menuList", menuList);
        return "/index";
    }

    /**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "loginOut", method = RequestMethod.GET)
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login.do";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String name, String pass, ModelMap map, HttpSession session) {
        AdminUser user = adminUserService.login(name, pass);
        if (user == null) {
            map.put("error", "用户名或密码错误");
            return "login";
        }
        if (user.getRoleId() != null) {
            Role role = roleService.selectById(user.getRoleId());
            user.setRoleName(role.getName());
        }
        session.setAttribute(AdminUser.SESSION_ID, user);
        session.setAttribute(AdminUser.SESSION_AUTH_ID, menuService.selectAuthorities(user.getId()));
        return "redirect:/admin/index.do";
    }
}
