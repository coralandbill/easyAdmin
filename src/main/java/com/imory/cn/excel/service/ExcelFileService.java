package com.imory.cn.excel.service;

import com.imory.cn.excel.dto.ExcelFile;

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
public interface ExcelFileService {

    List<ExcelFile> listExcelFile(Map<String, Object> paramsMap);

    int countExcelFile(Map<String, Object> paramsMap);

    Integer saveExcelFile(Map<String, Object> paramsMap);

    boolean analysisXls(String filePath, Integer companyId, String fileDate, Integer creator, Integer fileId);

}
