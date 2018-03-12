package com.imory.cn.user.service.impl;

import com.imory.cn.user.dao.UserInformMapper;
import com.imory.cn.user.dto.UserInform;
import com.imory.cn.user.dto.UserInformExample;
import com.imory.cn.user.service.UserInformService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
@Service
public class UserInformServiceImpl implements UserInformService {

    @Autowired
    private UserInformMapper userInformMapper;

    @Override
    public List<UserInform> listUserInform(int startPos, int pageSize, String title) {
        UserInformExample userInformExample = new UserInformExample();
        UserInformExample.Criteria criteria = userInformExample.createCriteria();
        if (StringUtils.isNotBlank(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        userInformExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);
        return userInformMapper.selectByExample(userInformExample);
    }

    @Override
    public int countUserInform(String title) {
        UserInformExample userInformExample = new UserInformExample();
        UserInformExample.Criteria criteria = userInformExample.createCriteria();
        if (StringUtils.isNotBlank(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        return userInformMapper.countByExample(userInformExample);
    }

    @Override
    public UserInform selectById(Integer id) {
        return userInformMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUserInformWithBLOB(UserInform userInform) {
        return userInformMapper.updateByPrimaryKeyWithBLOBs(userInform) > 0;
    }

    @Override
    public boolean replayUserInform(Integer id, String replayContent) {
        UserInform userInform = userInformMapper.selectByPrimaryKey(id);
        userInform.setReplayContent(replayContent);
        userInform.setState(1);
        userInform.setReplayDate(new Date());
        return userInformMapper.updateByPrimaryKey(userInform) > 0;
    }
}
