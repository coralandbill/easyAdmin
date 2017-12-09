package com.imory.cn.admin.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.role.dto.Role;
import com.imory.cn.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
@RequestMapping("admin/user")
@Controller
public class AdminUserController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(HttpSession session, Model model)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        //获取当前管理员创建的角色
        List<Role> roleList = roleService.listRoleByUserId(adminUser.getId());
        model.addAttribute("roleList", roleList);
        return "user/userIndex";
    }
}
