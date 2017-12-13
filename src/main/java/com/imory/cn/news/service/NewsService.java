package com.imory.cn.news.service;

import com.imory.cn.news.dto.News;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/9
 */
public interface NewsService {

    boolean saveNews(News news);

    boolean updateNews(News news);

    boolean updateNewsWithBLOB(News news);

    List<News> listNews(int startPos, int pageSize, String title, Integer userId, Integer newsType);

    int countNews(String title, Integer userId, Integer newsType);

    News selectById(Integer id);

    boolean deleteNews(String ids);

}
