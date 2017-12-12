package com.imory.cn.news.controller;

import com.imory.cn.annotation.SessionCheck;
import com.imory.cn.news.dto.News;
import com.imory.cn.news.service.NewsService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    @Value("#{runtimeProperties['img.uploadfiledir']}")
    private String imgDir;

    @Value("#{runtimeProperties['img.uploadfiledir_by']}")
    private String imgDir_BY;

    @Value("#{runtimeProperties['img.url']}")
    private String imgUrl;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/index")
    @SessionCheck
    public String index(Integer newsType, Model model) {
        model.addAttribute("newsType", newsType);
        return "news/news";
    }

    @RequestMapping("/saveNews")
    public String saveNews(@RequestParam MultipartFile imgFile, String title, String source,
                           String content, String newsDate, Integer newsType, Integer newsId) {
        JSONObject jsonObject = new JSONObject();
        String uploadImgUrl = "";
        if (imgFile != null && imgFile.getSize() > 0) {
            String imgName = new Date().getTime() + ".jpg";
            if (!imgDir.endsWith(File.separator)) {
                imgDir = imgDir + File.separator;
            }
            if (!imgDir_BY.endsWith(File.separator)) {
                imgDir_BY = imgDir_BY + File.separator;
            }
            String uploadDir = imgDir + "images/news" + File.separator;
            String uploadDir_BY = imgDir_BY + "images/news" + File.separator;
            File newFile = new File(uploadDir);
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            try {
                FileUtils.copyInputStreamToFile(imgFile.getInputStream(), new File(uploadDir, imgName));
                FileUtils.copyFile(new File(uploadDir + imgName), new File(uploadDir_BY + imgName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            uploadImgUrl = imgUrl + "/images/news/" + imgName;
        }
        News news;
        if (newsId != null) {
            news = newsService.selectById(newsId);
        } else {
            news = new News();
        }
        if (StringUtils.isNotBlank(title)) {
            news.setTitle(title);
        }
        if (StringUtils.isNotBlank(uploadImgUrl)) {
            news.setImgUrl(uploadImgUrl);
        }
        if (StringUtils.isNotBlank(source)) {
            news.setSource(source);
        }
        if (StringUtils.isNotBlank(content)) {
            news.setContent(content);
        }
        if (StringUtils.isNotBlank(newsDate)) {
            news.setNewsDate(DateTime.parse(newsDate, DateTimeFormat.forPattern("yyyy-MM-dd")).toDate());
        }
        news.setNewsType(newsType);
        if (newsId != null) {
            jsonObject.put("success", newsService.updateNewsWithBLOB(news));
        } else {
            jsonObject.put("success", newsService.saveNews(news));
        }
        return "redirect:/admin/news/index.do";
    }

    @RequestMapping("/addNews")
    @SessionCheck
    public String addNews(Integer newsId, Integer newsType, Model model) {
        if (newsId == null) {
            model.addAttribute("initDate", new DateTime(new Date()).toString("yyyy-MM-dd"));
        } else {
            News news = newsService.selectById(newsId);
            model.addAttribute("initDate", new DateTime(news.getNewsDate()).toString("yyyy-MM-dd"));
            model.addAttribute("newsId", newsId);
            model.addAttribute("news", news);
        }
        model.addAttribute("newsType", newsType);
        return "news/addNews";
    }
}
