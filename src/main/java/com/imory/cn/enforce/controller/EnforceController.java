package com.imory.cn.enforce.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.enforce.dto.Enforce;
import com.imory.cn.enforce.service.EnforceService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
@RequestMapping("admin/enforce")
@Controller
public class EnforceController {

    @Autowired
    private EnforceService enforceService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model) {
        return "enforce/enforceIndex";
    }

    @RequestMapping("/edit")
    @SessionCheck
    public String edit(Integer id, Model model) {
        if (id != null) {
            Enforce enforce = enforceService.selectById(id);
            model.addAttribute("id", id);
            model.addAttribute("enforce", enforce);
            model.addAttribute("initDate", new DateTime(enforce.getEnforceDate()).toString("yyyy-MM-dd"));
        } else {
            model.addAttribute("initDate", new DateTime(new Date()).toString("yyyy-MM-dd"));
        }
        return "enforce/editEnforce";
    }

    @RequestMapping("/saveNews")
    public String saveNews(String title, String enforceDate, String enforceDesc,
                           Integer id, HttpSession session) {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        JSONObject jsonObject = new JSONObject();
        Enforce enforce;
        if (id != null) {
            enforce = enforceService.selectById(id);
        } else {
            enforce = new Enforce();
        }
        if (StringUtils.isNotBlank(title)) {
            enforce.setTitle(title);
        }
        if (StringUtils.isNotBlank(enforceDesc)) {
            enforce.setEnforceDesc(enforceDesc);
        }
        if (StringUtils.isNotBlank(enforceDate)) {
            enforce.setEnforceDate(DateTime.parse(enforceDate, DateTimeFormat.forPattern("yyyy-MM-dd")).toDate());
        }
        if (id != null) {
            enforce.setUpateTime(new Date());
            jsonObject.put("success", enforceService.updateEnforceWithBLOB(enforce));
        } else {
            enforce.setCreateTime(new Date());
            enforce.setCreator(adminUser.getId());
            jsonObject.put("success", enforceService.saveEnforce(enforce));
        }
        return "redirect:/admin/enforce/index.do";
    }
}
