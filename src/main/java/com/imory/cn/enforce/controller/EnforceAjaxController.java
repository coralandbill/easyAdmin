package com.imory.cn.enforce.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.enforce.dto.Enforce;
import com.imory.cn.enforce.service.EnforceService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
@RequestMapping("admin/enforceAjax")
@RestController
public class EnforceAjaxController {

    @Autowired
    private EnforceService enforceService;

    @RequestMapping("/listEnforce")
    public String listEnforce(String search, Integer limit, Integer offset, HttpSession session) {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (search == null) search = "";

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<Enforce> enforceList = enforceService.listEnforce(offset, limit, search, adminUser.getId());
        BeanMap roleBeanMap = BeanMap.create(new Enforce());
        for (Enforce enforce : enforceList) {
            roleBeanMap.setBean(enforce);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(enforce.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.put("newsTimeStr", new DateTime(enforce.getEnforceDate()).toString("yyyy-MM-dd"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = enforceService.countEnforce(search, adminUser.getId());
        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/getById")
    public String getById(Integer id) {
        JSONObject jsonObject = new JSONObject();
        Enforce enforce = enforceService.selectById(id);
        if (enforce != null) {
            BeanMap roleBeanMap = BeanMap.create(new Enforce());
            roleBeanMap.setBean(enforce);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("news", branchInstMap);
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/deleteNews")
    public String deleteNews(String ids) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", enforceService.deleteEnforce(ids));
        return jsonObject.toString();
    }
}
