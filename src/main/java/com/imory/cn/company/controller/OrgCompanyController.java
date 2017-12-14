package com.imory.cn.company.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.company.dto.OrgCompany;
import com.imory.cn.company.service.OrgCompanyService;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/13
 */
@RequestMapping("admin/orgCompany")
@Controller
public class OrgCompanyController {

    @Autowired
    private OrgCompanyService orgCompanyService;

    @RequestMapping("/index")
    @SessionCheck
    public String index()
    {
        return "orgCompany/orgCompany";
    }

    @RequestMapping("/file")
    @SessionCheck
    public String file()
    {
        return "orgCompany/orgCompanyFile";
    }

    @RequestMapping(value = "/saveOrgCompany", method = RequestMethod.POST)
    public String saveOrgCompany(String companyName, String logonId, String logonPsd,
                                 String province, String city, String code, String street,
                                 String address, Integer orgCompanyId, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);

        JSONObject jsonObject = new JSONObject();
        OrgCompany orgCompany;
        if (orgCompanyId != null)
        {
            orgCompany = orgCompanyService.selectById(orgCompanyId);
        } else
        {
            orgCompany = new OrgCompany();
        }

        if (StringUtils.isNotBlank(companyName))
        {
            orgCompany.setCompanyName(companyName);
        }
        if (StringUtils.isNotBlank(logonId))
        {
            orgCompany.setLogonId(logonId);
        }
        if (StringUtils.isNotBlank(logonPsd))
        {
            orgCompany.setLogonPsd(logonPsd);
        }
        if (StringUtils.isNotBlank(province))
        {
            orgCompany.setProvince(province);
        }
        if (StringUtils.isNotBlank(city))
        {
            orgCompany.setCity(city);
        }
        if (StringUtils.isNotBlank(code))
        {
            orgCompany.setCode(code);
        }
        if (StringUtils.isNotBlank(street))
        {
            orgCompany.setStreet(street);
        }
        if (StringUtils.isNotBlank(address))
        {
            orgCompany.setAddress(address);
        }
        if (orgCompanyId != null)
        {
            orgCompany.setState(0);
            orgCompany.setCreateTime(new Date());
            orgCompany.setCreator(adminUser.getId());
            orgCompany.setEnable(Boolean.FALSE);
            jsonObject.put("success", orgCompanyService.updateOrgCompany(orgCompany));
        } else
        {
            orgCompany.setUpdateTime(new Date());
            jsonObject.put("success", orgCompanyService.saveOrgCompany(orgCompany));
        }

        return "redirect:/admin/orgCompany/index.do";
    }

    @RequestMapping("/editOrgCompany")
    @SessionCheck
    public String editOrgCompany(Integer orgCompanyId, Model model)
    {
        if (orgCompanyId != null)
        {
            OrgCompany orgCompany = orgCompanyService.selectById(orgCompanyId);
            model.addAttribute("orgCompany", orgCompany);
            model.addAttribute("orgCompanyId", orgCompanyId);
        }
        return "orgCompany/addOrgCompany";
    }
}
