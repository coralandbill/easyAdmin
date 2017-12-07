package com.imory.cn.role.controller;

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
 * @Date 2017/12/7
 */
@Controller
@RequestMapping("admin/role")
public class RoleController {

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model)
    {
        return "role/role";
    }
}
