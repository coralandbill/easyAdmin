package com.imory.cn.company.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.company.dto.OrgCompany;
import com.imory.cn.company.service.OrgCompanyService;
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

    @RequestMapping("/listNews")
    public String listNews(String search, Integer limit, Integer offset, Integer newsType, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (search == null) search = "";

        Map<String, Object> paramsMap = new HashMap<>();

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
        jsonObject.put("orgCompany", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }
}
