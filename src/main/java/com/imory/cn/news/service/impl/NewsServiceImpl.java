package com.imory.cn.news.service.impl;

import com.imory.cn.news.dao.NewsMapper;
import com.imory.cn.news.dto.News;
import com.imory.cn.news.dto.NewsExample;
import com.imory.cn.news.service.NewsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public boolean saveNews(News news) {
        return newsMapper.insert(news) > 0;
    }

    @Override
    public boolean updateNews(News news) {
        return newsMapper.updateByPrimaryKey(news) > 0;
    }

    @Override
    public boolean updateNewsWithBLOB(News news) {
        return newsMapper.updateByPrimaryKeyWithBLOBs(news) > 0;
    }

    @Override
    public List<News> listNews(int startPos, int pageSize, String title, Integer userId, Integer newsType) {
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        criteria.andNewsTypeEqualTo(newsType);
        if (StringUtils.isNotBlank(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (userId != -1) {
            criteria.andCreatorEqualTo(userId);
        }
        newsExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);

        return newsMapper.selectByExample(newsExample);
    }

    @Override
    public int countNews(String title, Integer userId, Integer newsType) {
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        criteria.andNewsTypeEqualTo(newsType);
        if (StringUtils.isNotBlank(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (userId != -1) {
            criteria.andCreatorEqualTo(userId);
        }
        return newsMapper.countByExample(newsExample);
    }

    @Override
    public News selectById(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteNews(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            newsMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return true;
    }
}
