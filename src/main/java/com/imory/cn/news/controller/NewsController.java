package com.imory.cn.news.controller;

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
@RequestMapping("admin/news")
@Controller
public class NewsController {

    @RequestMapping("/index")
    @SessionCheck
    public String index(Integer newsType, Model model)
    {
        model.addAttribute("newsType", newsType);
        return "news/news";
    }

    @RequestMapping("/addNews")
    @SessionCheck
    public String addNews(Integer newsType, Model model)
    {
        model.addAttribute("newsType", newsType);
        return "news/addNews";
    }
}
