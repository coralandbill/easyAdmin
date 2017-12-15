package com.imory.cn.excel.service.impl;

import com.imory.cn.excel.dao.ExcelFileMapper;
import com.imory.cn.excel.dto.ExcelFile;
import com.imory.cn.excel.dto.ExcelFileExample;
import com.imory.cn.excel.service.ExcelFileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ExcelFileServiceImpl implements ExcelFileService {

    @Autowired
    private ExcelFileMapper excelFileMapper;

    @Override
    public List<ExcelFile> listExcelFile(Map<String, Object> paramsMap)
    {
        int startPos = (int) paramsMap.get("startPos");
        int pageSize = (int) paramsMap.get("pageSize");
        String fileName = (String) paramsMap.get("fileName");
        Integer companyId = (Integer) paramsMap.get("companyId");

        ExcelFileExample excelFileExample = new ExcelFileExample();
        ExcelFileExample.Criteria criteria = excelFileExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        if (StringUtils.isNotBlank(fileName))
        {
            criteria.andFileNameLike("%" + fileName + "%");
        }
        excelFileExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);

        return excelFileMapper.selectByExample(excelFileExample);
    }

    @Override
    public int countExcelFile(Map<String, Object> paramsMap)
    {
        Integer companyId = (Integer) paramsMap.get("companyId");
        String fileName = (String) paramsMap.get("fileName");
        ExcelFileExample excelFileExample = new ExcelFileExample();
        ExcelFileExample.Criteria criteria = excelFileExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        if (StringUtils.isNotBlank(fileName))
        {
            criteria.andFileNameLike("%" + fileName + "%");
        }

        return excelFileMapper.countByExample(excelFileExample);
    }
}
