package com.imory.cn.enforce.service;

import com.imory.cn.enforce.dto.Enforce;

import java.util.List;

/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
public interface EnforceService {

    List<Enforce> listEnforce(int startPos, int pageSize, String title, Integer userId);

    int countEnforce(String title, Integer userId);

    Enforce selectById(Integer id);

    boolean deleteEnforce(String ids);

    boolean updateEnforceWithBLOB(Enforce enforce);

    boolean saveEnforce(Enforce enforce);
}
