package com.imory.cn.news.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.news.dto.News;
import com.imory.cn.news.service.NewsService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * @Date 2017/12/9
 */
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/listRole")
    public String listRole(String search, Integer limit, Integer offset, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (search == null) search = "";

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<News> newsList = newsService.listNews(offset, limit, search, adminUser.getId());
        BeanMap roleBeanMap = BeanMap.create(new News());
        for (News news : newsList)
        {
            roleBeanMap.setBean(news);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(news.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = newsService.countNews(search, adminUser.getId());

        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }
}
