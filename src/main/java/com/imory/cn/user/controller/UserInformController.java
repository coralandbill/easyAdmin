package com.imory.cn.user.controller;

import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.user.service.UserInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
@RequestMapping("admin/userInform")
@Controller
public class UserInformController {

    @Autowired
    private UserInformService userInformService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model) {
        return "userInform/index";
    }

}
