package com.imory.cn.admin.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.admin.service.AdminUserService;
import com.imory.cn.userRole.dto.UserRole;
import com.imory.cn.userRole.service.UserRoleService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import com.imory.cn.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
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
 * @Date 2017/12/9
 */
@RequestMapping("admin/userAjax")
@RestController
public class AdminUserAjaxController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/listUser")
    public String listUser(String search, Integer limit, Integer offset, HttpSession session) {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);

        if (search == null) search = "";

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<AdminUser> adminUserList = adminUserService.listUser(offset, limit, search, adminUser.getId());
        BeanMap roleBeanMap = BeanMap.create(new AdminUser());
        for (AdminUser user : adminUserList) {
            roleBeanMap.setBean(user);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("updateTimeStr", new DateTime(user.getUpdate_time()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = adminUserService.countUser(search, adminUser.getId());

        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/saveUser")
    public String saveRole(String name, String psw, String email,
                           Integer flag, Integer userId, String street, HttpSession session) {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        JSONObject jsonObject = new JSONObject();
        AdminUser user;
        if (userId != null) {
            user = adminUserService.selectById(userId);
        } else {
            user = new AdminUser();
            user.setUpdate_time(new Date());
            user.setCreator(adminUser.getId());
            user.setUpdate_user(adminUser.getId());
        }
        if (StringUtils.isNotBlank(name)) {
            user.setName(name);
        }
        if (StringUtils.isNotBlank(psw)) {
            user.setPsw(MD5Util.MD5(psw));
        }
        if (StringUtils.isNotBlank(email)) {
            user.setEmail(email);
        }
        if (StringUtils.isNotBlank(street)) {
            user.setStreet(street);
        }
        if (flag != null) {
            user.setFlag(flag);
        }
        if (userId != null) {
            jsonObject.put("success", adminUserService.update(user));
        } else {
            jsonObject.put("success", adminUserService.insert(user));
        }

        return jsonObject.toString();
    }

    @RequestMapping("/resetPwd")
    public String resetPwd(Integer userId, String pwd) {
        JSONObject jsonObject = new JSONObject();
        AdminUser adminUser = adminUserService.selectById(userId);
        if (adminUser != null) {
            if (adminUserService.updatePass(userId, pwd)) {
                jsonObject.put("success", Boolean.TRUE);
            } else {
                jsonObject.put("success", Boolean.FALSE);
            }
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/getById")
    public String getById(Integer id) {
        JSONObject jsonObject = new JSONObject();
        AdminUser adminUser = adminUserService.selectById(id);
        if (adminUser != null) {
            BeanMap roleBeanMap = BeanMap.create(new AdminUser());
            roleBeanMap.setBean(adminUser);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("adminUser", branchInstMap);
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/getUserRoleId")
    public String getUserRoleId(Integer userId) {
        JSONObject jsonObject = new JSONObject();
        AdminUser adminUser = adminUserService.selectById(userId);
        if (adminUser != null) {
            List<UserRole> userRoleList = userRoleService.getUserRoleByUserId(userId);
            if (userRoleList != null && userRoleList.size() > 0) {
                jsonObject.put("roleId", userRoleList.get(0).getRoleid());
                jsonObject.put("success", Boolean.TRUE);
            } else {
                jsonObject.put("success", Boolean.FALSE);
            }
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/saveUserRole")
    public String saveUserRole(Integer userId, Integer roleId, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (adminUser != null) {
            //获取UserRole
            List<UserRole> userRoleList = userRoleService.getUserRoleByUserId(userId);
            if (userRoleList != null && userRoleList.size() > 0) {
                UserRole userRole = userRoleList.get(0);
                userRole.setRoleid(roleId);
                userRole.setCreate_time(new Date());
                if (userRoleService.updateUserRole(userRole)) {
                    jsonObject.put("success", Boolean.TRUE);
                } else {
                    jsonObject.put("success", Boolean.FALSE);
                }
            } else {
                UserRole userRole = new UserRole();
                userRole.setRoleid(roleId);
                userRole.setUserid(userId);
                userRole.setCreator(adminUser.getId());
                userRole.setCreate_time(new Date());
                if (userRoleService.saveUserRole(userRole)) {
                    jsonObject.put("success", Boolean.TRUE);
                } else {
                    jsonObject.put("success", Boolean.FALSE);
                }
            }
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/deleteUserRole")
    public String deleteUserRole(String ids, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (adminUser != null) {
            adminUserService.deleteUserRole(adminUser.getId(), ids);
            jsonObject.put("success", Boolean.TRUE);
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }
}
