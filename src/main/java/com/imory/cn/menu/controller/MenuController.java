package com.imory.cn.menu.controller;

import com.google.gson.Gson;
import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date 2017/12/6
 */
@RequestMapping("admin/menu")
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Model model)
    {
        model.addAttribute("menu",new Gson().toJson(menuService.selectAll()));
        return "menu/menu";
    }

}
