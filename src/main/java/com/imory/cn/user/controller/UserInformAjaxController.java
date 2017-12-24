package com.imory.cn.user.controller;

import com.imory.cn.user.dto.UserInform;
import com.imory.cn.user.service.UserInformService;
import com.imory.cn.utils.GetTotalPageNumUtil;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>名称</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/24
 */
@RequestMapping("admin/userInformAjax")
@RestController
public class UserInformAjaxController {

    @Autowired
    private UserInformService userInformService;

    @RequestMapping("/listUserInform")
    public String listUserInform(String search, Integer limit, Integer offset) {
        if (search == null) search = "";

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<UserInform> userInformList = userInformService.listUserInform(offset, limit, search);
        BeanMap roleBeanMap = BeanMap.create(new UserInform());
        for (UserInform userInform : userInformList) {
            roleBeanMap.setBean(userInform);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(userInform.getCreateTime()).toString("yyyy-MM-dd HH:mm:ss"));
            branchInstMap.put("newsTimeStr", new DateTime(userInform.getReplayDate()).toString("yyyy-MM-dd"));
            branchInstMap.putAll(roleBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = userInformService.countUserInform(search);
        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }

    @RequestMapping("/getById")
    public String getById(Integer id) {
        JSONObject jsonObject = new JSONObject();
        UserInform userInform = userInformService.selectById(id);
        if (userInform != null) {
            BeanMap roleBeanMap = BeanMap.create(new UserInform());
            roleBeanMap.setBean(userInform);
            Map branchInstMap = new HashMap<>();
            branchInstMap.putAll(roleBeanMap);
            jsonObject.put("success", Boolean.TRUE);
            jsonObject.put("userInform", branchInstMap);
        } else {
            jsonObject.put("success", Boolean.FALSE);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/update")
    public String update(Integer id, String replayContent) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", userInformService.replayUserInform(id, replayContent));
        return jsonObject.toString();
    }
}
