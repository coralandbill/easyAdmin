package com.imory.cn.admin.controller;

import com.imory.cn.annotation.SessionCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model)
    {
        return "user/userIndex";
    }
}
