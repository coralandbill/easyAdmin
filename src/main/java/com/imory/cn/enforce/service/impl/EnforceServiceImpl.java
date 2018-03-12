package com.imory.cn.enforce.service.impl;

import com.imory.cn.enforce.dao.EnforceMapper;
import com.imory.cn.enforce.dto.Enforce;
import com.imory.cn.enforce.dto.EnforceExample;
import com.imory.cn.enforce.service.EnforceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
@Service
public class EnforceServiceImpl implements EnforceService {

    @Autowired
    private EnforceMapper enforceMapper;

    @Override
    public List<Enforce> listEnforce(int startPos, int pageSize, String title, Integer userId) {
        EnforceExample enforceExample = new EnforceExample();
        EnforceExample.Criteria criteria = enforceExample.createCriteria();
        if (StringUtils.isNotBlank(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (userId != -1) {
            criteria.andCreatorEqualTo(userId);
        }
        enforceExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);
        return enforceMapper.selectByExample(enforceExample);
    }

    @Override
    public int countEnforce(String title, Integer userId) {
        EnforceExample enforceExample = new EnforceExample();
        EnforceExample.Criteria criteria = enforceExample.createCriteria();
        if (StringUtils.isNotBlank(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (userId != -1) {
            criteria.andCreatorEqualTo(userId);
        }
        return enforceMapper.countByExample(enforceExample);
    }

    @Override
    public Enforce selectById(Integer id) {
        return enforceMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteEnforce(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            enforceMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return true;
    }

    @Override
    public boolean updateEnforceWithBLOB(Enforce enforce) {
        return enforceMapper.updateByPrimaryKeyWithBLOBs(enforce) > 0;
    }

    @Override
    public boolean saveEnforce(Enforce enforce) {
        return enforceMapper.insert(enforce) > 0;
    }
}
