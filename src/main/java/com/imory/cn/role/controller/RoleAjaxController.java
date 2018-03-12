package com.imory.cn.role.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.role.dto.Role;
import com.imory.cn.role.service.RoleService;
import com.imory.cn.roleMenu.service.RoleMenuService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/7
 */
@RestController
@RequestMapping("admin/roleAjax")
public class RoleAjaxController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping("/listRole")
    public String listRole(String search, Integer limit, Integer offset, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (search == null) search = "";

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<Role> roleList = roleService.listRole(offset, limit, search, adminUser.getId());
        BeanMap roleBeanMap = BeanMap.create(new Role());
        for (Role role : roleList)
        {
            roleBeanMap.setBean(role);
            Map branchInstMap = new HashMap<>();

            branchInstMap.put("createTimeStr", new DateTime(role.getCreate_time()).toString("yyyy-MM-dd HH:mm"));


            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = roleService.countRole(search, adminUser.getId());

        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/saveRole")
    public String saveRole(String name, String desc, Integer roleId, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        JSONObject jsonObject = new JSONObject();
        Role role;
        if (roleId != null)
        {
            role = roleService.selectById(roleId);
        } else
        {
            role = new Role();
            role.setCreate_time(new Date());
            role.setCreator(adminUser.getId());
        }
        if (StringUtils.isNotBlank(name))
        {
            role.setName(name);
        }
        if (StringUtils.isNotBlank(desc))
        {
            role.setDescription(desc);
        }
        if (roleId != null)
        {
            jsonObject.put("success", roleService.update(role));
        } else
        {
            jsonObject.put("success", roleService.insert(role));
        }

        return jsonObject.toString();
    }

    @RequestMapping("/getById")
    public String getById(Integer id)
    {
        JSONObject jsonObject = new JSONObject();
        Role role = roleService.selectById(id);
        if (role != null)
        {
            BeanMap roleBeanMap = BeanMap.create(new Role());
            roleBeanMap.setBean(role);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("role", branchInstMap);
        } else
        {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/saveRoleMenu")
    public String saveRoleMenu(Integer roleId, String menuId, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject();
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        jsonObject.put("success", roleMenuService.updateRoleMenu(menuId, roleId, adminUser.getId()));
        return jsonObject.toString();
    }
}
