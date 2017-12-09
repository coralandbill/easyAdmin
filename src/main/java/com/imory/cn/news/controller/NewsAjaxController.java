package com.imory.cn.news.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.news.dto.News;
import com.imory.cn.news.service.NewsService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
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
 * @Date 2017/12/9
 */
@RequestMapping("admin/newsAjax")
@RestController
public class NewsAjaxController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/listNews")
    public String listNews(String search, Integer limit, Integer offset, HttpSession session)
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

    @RequestMapping("/getById")
    public String getById(Integer id)
    {
        JSONObject jsonObject = new JSONObject();
        News news = newsService.selectById(id);
        if (news != null)
        {
            BeanMap roleBeanMap = BeanMap.create(new News());
            roleBeanMap.setBean(news);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("news", branchInstMap);
        } else
        {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/saveNews")
    public String saveNews(String title, String imgUrl, String source,
                           String content, String newsDate, Integer newsType, Integer newsId)
    {
        JSONObject jsonObject = new JSONObject();
        News news;
        if (newsId != null)
        {
            news = newsService.selectById(newsId);
        } else
        {
            news = new News();
        }
        if (StringUtils.isNotBlank(title))
        {
            news.setTitle(title);
        }
        if (StringUtils.isNotBlank(imgUrl))
        {
            news.setImgUrl(imgUrl);
        }
        if (StringUtils.isNotBlank(source))
        {
            news.setSource(source);
        }
        if (StringUtils.isNotBlank(content))
        {
            news.setContent(content);
        }
        if (StringUtils.isNotBlank(newsDate))
        {
            news.setNewsDate(DateTime.parse(newsDate, DateTimeFormat.forPattern("yyyy-MM-dd")).toDate());
        }
        news.setNewsType(newsType);

        if (newsId != null)
        {
            jsonObject.put("success", newsService.updateNews(news));
        } else
        {
            jsonObject.put("success", newsService.saveNews(news));
        }
        return jsonObject.toString();
    }
}
