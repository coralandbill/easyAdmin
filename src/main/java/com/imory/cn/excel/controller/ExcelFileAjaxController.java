package com.imory.cn.excel.controller;

import com.imory.cn.admin.dto.AdminUser;
import com.imory.cn.excel.dto.ExcelFile;
import com.imory.cn.excel.service.ExcelFileService;
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
 * @Date 2017/12/15
 */
@RequestMapping("admin/excelFileAjax")
@RestController
public class ExcelFileAjaxController {

    @Value("#{runtimeProperties['excel.uploadfiledir']}")
    private String excelDir;

    @Value("#{runtimeProperties['excel.uploadfiledir_by']}")
    private String excelDir_BY;

    @Value("#{runtimeProperties['web.url']}")
    private String webUrl;

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

    @RequestMapping("/saveExcelFile")
    public String saveExcelFile(@RequestParam MultipartFile excelFile, String fileDate, Integer companyId, HttpSession session)
    {
        AdminUser adminUser = (AdminUser) session.getAttribute(AdminUser.SESSION_ID);

        JSONObject jsonObject = new JSONObject();

        String fileName = excelFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        String excelName = new Date().getTime() + suffix;
        if (!excelDir.endsWith(File.separator))
        {
            excelDir = excelDir + File.separator;
        }
        if (!excelDir_BY.endsWith(File.separator))
        {
            excelDir_BY = excelDir_BY + File.separator;
        }
        String uploadDir = excelDir + "excel" + File.separator;
        String uploadDir_BY = excelDir_BY + "excel" + File.separator;
        File newFile = new File(uploadDir);
        if (!newFile.exists())
        {
            newFile.mkdirs();
        }
        try
        {
            //上传到本地
            FileUtils.copyInputStreamToFile(excelFile.getInputStream(), new File(uploadDir, fileName));
            //copy备份文件
            FileUtils.copyFile(new File(uploadDir + fileName), new File(uploadDir + excelName));
            //copy文件到编译目录
            FileUtils.copyFile(new File(uploadDir + fileName), new File(uploadDir_BY + excelName));

            //保存解析记录
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put("companyId", companyId);
            paramsMap.put("fileName", fileName);
            paramsMap.put("fileName_bk", excelName);
            paramsMap.put("fileDate", fileDate);
            paramsMap.put("fileUrl", webUrl + "/excel/" + fileName);
            paramsMap.put("fileUrlBak", webUrl + "/excel/" + excelName);
            paramsMap.put("filePath", uploadDir);
            paramsMap.put("creator", adminUser.getId());
            if (excelFileService.saveExcelFile(paramsMap))
            {
                //开始解析文件
                jsonObject.put("success", excelFileService.analysisXls(uploadDir + excelName, companyId, fileDate, adminUser.getId()));
            } else
            {
                //开始解析文件
                jsonObject.put("success", false);
            }
            jsonObject.put("webUrl", webUrl + "/excel/" + excelName);
            jsonObject.put("file_path", webUrl + "/excel/" + excelName);
        } catch (IOException e)
        {
            e.printStackTrace();
            jsonObject.put("success", false);
        }
        return jsonObject.toString();
    }
}
