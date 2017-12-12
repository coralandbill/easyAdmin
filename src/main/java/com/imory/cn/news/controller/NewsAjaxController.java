package com.imory.cn.news.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.news.dto.News;
import com.imory.cn.news.service.NewsService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

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

    @Value("#{runtimeProperties['img.uploadfiledir']}")
    private String imgDir;

    @Value("#{runtimeProperties['img.uploadfiledir_by']}")
    private String imgDir_BY;

    @Value("#{runtimeProperties['img.url']}")
    private String imgUrl;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/listNews")
    public String listNews(String search, Integer limit, Integer offset, Integer newsType, HttpSession session) {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);
        if (search == null) search = "";

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<News> newsList = newsService.listNews(offset, limit, search, adminUser.getId(), newsType);
        BeanMap roleBeanMap = BeanMap.create(new News());
        for (News news : newsList) {
            roleBeanMap.setBean(news);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(news.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.put("newsTimeStr", new DateTime(news.getNewsDate()).toString("yyyy-MM-dd"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = newsService.countNews(search, adminUser.getId(), newsType);
        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/getById")
    public String getById(Integer id) {
        JSONObject jsonObject = new JSONObject();
        News news = newsService.selectById(id);
        if (news != null) {
            BeanMap roleBeanMap = BeanMap.create(new News());
            roleBeanMap.setBean(news);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("news", branchInstMap);
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/deleteNews")
    public String deleteNews(String ids) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", newsService.deleteNews(ids));
        return jsonObject.toString();
    }

    @RequestMapping("/uploadImg")
    public String uploadImg(@RequestParam MultipartFile file) {
        JSONObject jsonObject = new JSONObject();
        String imgName = new Date().getTime() + ".jpg";
        if (!imgDir.endsWith(File.separator)) {
            imgDir = imgDir + File.separator;
        }
        if (!imgDir_BY.endsWith(File.separator)) {
            imgDir_BY = imgDir_BY + File.separator;
        }
        String uploadDir = imgDir + "images" + File.separator;
        String uploadDir_BY = imgDir_BY + "images" + File.separator;
        File newFile = new File(uploadDir);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadDir, imgName));
            FileUtils.copyFile(new File(uploadDir + imgName), new File(uploadDir_BY + imgName));
            jsonObject.put("success", true);
            jsonObject.put("imgUrl", imgUrl + "/images/" + imgName);
            jsonObject.put("file_path", imgUrl + "/images/" + imgName);
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("success", false);
        }
        return jsonObject.toString();
    }
}
