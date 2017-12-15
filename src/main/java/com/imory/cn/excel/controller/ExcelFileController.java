package com.imory.cn.excel.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.company.service.OrgCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("admin/excelFile")
@Controller
public class ExcelFileController {

    @Autowired
    private OrgCompanyService orgCompanyService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(@RequestParam("companyId") Integer companyId, Integer flag, HttpSession session, Model model)
    {
        List<String> authUrlList = (List<String>) session.getAttribute(AdminUser.SESSION_AUTH_ID);
        boolean hasUploadFlag = false;
        boolean hasUpdateFlag = false;
        for (String url : authUrlList)
        {
            if ("/admin/company/uploadFile.do".equalsIgnoreCase(url))
            {
                hasUploadFlag = true;
            }
            if ("/admin/company/updateFile.do".equalsIgnoreCase(url))
            {
                hasUpdateFlag = true;
            }
        }
        model.addAttribute("companyId", companyId);
        model.addAttribute("flag", flag);
        model.addAttribute("hasUploadFlag", hasUploadFlag);
        model.addAttribute("hasUpdateFlag", hasUpdateFlag);
        model.addAttribute("orgCompany", orgCompanyService.selectById(companyId));
        return "excel/excelFile";
    }
}
