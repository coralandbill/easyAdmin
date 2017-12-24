package com.imory.cn.user.service;

import com.imory.cn.user.dto.UserInform;

import java.util.List;

/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
public interface UserInformService {

    List<UserInform> listUserInform(int startPos, int pageSize, String title);

    int countUserInform(String title);

    UserInform selectById(Integer id);

    boolean updateUserInformWithBLOB(UserInform userInform);

    boolean replayUserInform(Integer id, String replayContent);

}
