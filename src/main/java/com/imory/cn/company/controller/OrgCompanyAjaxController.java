package com.imory.cn.company.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.company.dto.OrgCompany;
import com.imory.cn.company.service.OrgCompanyService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 * @Date 2017/12/13
 */
@RequestMapping("admin/orgCompanyAjax")
@RestController
public class OrgCompanyAjaxController {

    @Autowired
    private OrgCompanyService orgCompanyService;

    @RequestMapping("/listOrgCompany")
    public String listOrgCompany(String search, Integer limit, Integer offset)
    {
        if (search == null) search = "";

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("companyName", search);
        paramsMap.put("startPos", offset);
        paramsMap.put("pageSize", limit);

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<OrgCompany> orgCompanyList = orgCompanyService.listOrgCompany(paramsMap);
        BeanMap roleBeanMap = BeanMap.create(new OrgCompany());
        for (OrgCompany orgCompany : orgCompanyList)
        {
            roleBeanMap.setBean(orgCompany);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(orgCompany.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = orgCompanyService.countOrgCompany(paramsMap);
        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/listOrgCompanyFile")
    public String listOrgCompanyFile(String search, Integer limit, Integer offset, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (search == null) search = "";

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("companyName", search);
        paramsMap.put("startPos", offset);
        paramsMap.put("pageSize", limit);
        if (adminUser.getId() != -1)
        {
            paramsMap.put("street", adminUser.getStreet());
        }

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<OrgCompany> orgCompanyList = orgCompanyService.listOrgCompany(paramsMap);
        BeanMap roleBeanMap = BeanMap.create(new OrgCompany());
        for (OrgCompany orgCompany : orgCompanyList)
        {
            roleBeanMap.setBean(orgCompany);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(orgCompany.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = orgCompanyService.countOrgCompany(paramsMap);
        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/getById")
    public String getById(Integer id)
    {
        JSONObject jsonObject = new JSONObject();
        OrgCompany orgCompany = orgCompanyService.selectById(id);
        if (orgCompany != null)
        {
            BeanMap roleBeanMap = BeanMap.create(new OrgCompany());
            roleBeanMap.setBean(orgCompany);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("orgCompany", branchInstMap);
        } else
        {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/deleteOrgCompany")
    public String deleteOrgCompany(String ids)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", orgCompanyService.deleteOrgCompany(ids));
        return jsonObject.toString();
    }

}
