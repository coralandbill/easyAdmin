package com.imory.cn.news.controller;

import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.news.dto.News;
import com.imory.cn.news.service.NewsService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

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

    @Autowired
    private NewsService newsService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Integer newsType, Model model)
    {
        model.addAttribute("newsType", newsType);
        return "news/news";
    }

    @RequestMapping("/saveNews")
    public String saveNews(@RequestParam MultipartFile imgFile, String title, String imgUrl, String source,
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
        return "redirect:/admin/news/index.do";
    }

    @RequestMapping("/addNews")
    @SessionCheck
    public String addNews(Integer newsId, Integer newsType, Model model)
    {
        if (newsId == null)
        {
            model.addAttribute("initDate", new DateTime(new Date()).toString("yyyy-MM-dd"));
        }
        model.addAttribute("newsType", newsType);
        return "news/addNews";
    }
}
