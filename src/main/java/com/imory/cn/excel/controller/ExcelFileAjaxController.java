package com.imory.cn.excel.controller;

import com.imory.cn.excel.dto.ExcelFile;
import com.imory.cn.excel.service.ExcelFileService;
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
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/15
 */
@RequestMapping("admin/excelFileAjax")
@RestController
public class ExcelFileAjaxController {

    @Autowired
    private ExcelFileService excelFileService;

    @RequestMapping("/listCompanyFile")
    public String listCompanyFile(String search, Integer limit, Integer offset, Integer companyId)
    {
        if (search == null) search = "";

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("fileName", search);
        paramsMap.put("companyId", companyId);
        paramsMap.put("startPos", offset);
        paramsMap.put("pageSize", limit);

        JSONObject jsonObject = new JSONObject();

        List<Map> resultList = new ArrayList<>();
        List<ExcelFile> excelFileList = excelFileService.listExcelFile(paramsMap);
        BeanMap fileBeanMap = BeanMap.create(new ExcelFile());
        for (ExcelFile excelFile : excelFileList)
        {
            fileBeanMap.setBean(excelFile);
            Map branchInstMap = new HashMap<>();
            branchInstMap.put("createTimeStr", new DateTime(excelFile.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
            branchInstMap.putAll(fileBeanMap);
            resultList.add(branchInstMap);
        }

        int roleCnt = excelFileService.countExcelFile(paramsMap);
        jsonObject.put("rows", resultList);
        jsonObject.put("total", roleCnt);
        jsonObject.put("page", GetTotalPageNumUtil.getTotalPage(roleCnt, limit));

        return jsonObject.toString();
    }
}
