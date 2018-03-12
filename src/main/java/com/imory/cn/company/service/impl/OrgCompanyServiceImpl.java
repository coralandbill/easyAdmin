package com.imory.cn.company.service.impl;

import com.imory.cn.company.dao.CompanyDangerMapper;
import com.imory.cn.company.dao.CompanyTransferMapper;
import com.imory.cn.company.dao.OneCompanyOneRecordMapper;
import com.imory.cn.company.dao.OrgCompanyMapper;
import com.imory.cn.company.dto.*;
import com.imory.cn.company.service.OrgCompanyService;
import com.imory.cn.excel.dao.ExcelFileMapper;
import com.imory.cn.excel.dto.ExcelFile;
import com.imory.cn.utils.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
 * @Date 2017/12/13
 */
@Service
public class OrgCompanyServiceImpl implements OrgCompanyService {

    @Autowired
    private OrgCompanyMapper orgCompanyMapper;

    @Autowired
    private CompanyDangerMapper companyDangerMapper;

    @Autowired
    private CompanyTransferMapper companyTransferMapper;

    @Autowired
    private OneCompanyOneRecordMapper oneCompanyOneRecordMapper;

    @Autowired
    private ExcelFileMapper excelFileMapper;

    @Value("#{runtimeProperties['excel.mbFile.path']}")
    private String MBFile_PATH;

    @Value("#{runtimeProperties['excel.uploadfiledir_by']}")
    private String excelDir_BY;

    @Value("#{runtimeProperties['web.url']}")
    private String webUrl;

    @Override
    public boolean saveOrgCompany(OrgCompany orgCompany) {
        return orgCompanyMapper.insert(orgCompany) > 0;
    }

    @Override
    public boolean updateOrgCompany(OrgCompany orgCompany) {
        return orgCompanyMapper.updateByPrimaryKey(orgCompany) > 0;
    }

    @Override
    public List<OrgCompany> listOrgCompany(Map<String, Object> paramsMap) {
        int startPos = (int) paramsMap.get("startPos");
        int pageSize = (int) paramsMap.get("pageSize");
        String companyName = (String) paramsMap.get("companyName");
        String street = (String) paramsMap.get("street");
        Integer userId = (Integer) paramsMap.get("userId");

        OrgCompanyExample orgCompanyExample = new OrgCompanyExample();
        OrgCompanyExample.Criteria criteria = orgCompanyExample.createCriteria();
        if (StringUtils.isNotBlank(companyName)) {
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        if (userId != -1 && StringUtils.isNotBlank(street)) {
            criteria.andStreetEqualTo(street);
        }
        criteria.andEnableEqualTo(Boolean.FALSE);
        orgCompanyExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);

        return orgCompanyMapper.selectByExample(orgCompanyExample);
    }

    @Override
    public int countOrgCompany(Map<String, Object> paramsMap) {
        String companyName = (String) paramsMap.get("companyName");
        String street = (String) paramsMap.get("street");

        OrgCompanyExample orgCompanyExample = new OrgCompanyExample();
        OrgCompanyExample.Criteria criteria = orgCompanyExample.createCriteria();
        if (StringUtils.isNotBlank(companyName)) {
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        if (StringUtils.isNotBlank(street)) {
            criteria.andStreetEqualTo(street);
        }
        criteria.andEnableEqualTo(Boolean.FALSE);
        return orgCompanyMapper.countByExample(orgCompanyExample);
    }

    @Override
    public OrgCompany selectById(Integer id) {
        return orgCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteOrgCompany(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            OrgCompany orgCompany = orgCompanyMapper.selectByPrimaryKey(Integer.valueOf(id));
            orgCompany.setEnable(Boolean.TRUE);
            orgCompanyMapper.updateByPrimaryKey(orgCompany);
        }
        return true;
    }

    @Override
    public List<CompanyDanger> listCompanyDanger(Integer fileId) {
        CompanyDangerExample companyDangerExample = new CompanyDangerExample();
        CompanyDangerExample.Criteria criteria = companyDangerExample.createCriteria();
        criteria.andFileIdEqualTo(fileId);
        companyDangerExample.setOrderByClause("orderNum asc");
        return companyDangerMapper.selectByExample(companyDangerExample);
    }

    @Override
    public List<CompanyTransfer> listCompanyTransfer(Integer fileId) {
        CompanyTransferExample companyTransferExample = new CompanyTransferExample();
        CompanyTransferExample.Criteria criteria = companyTransferExample.createCriteria();
        criteria.andFileIdEqualTo(fileId);
        companyTransferExample.setOrderByClause("orderNum asc");
        return companyTransferMapper.selectByExample(companyTransferExample);
    }

    @Override
    public boolean updateDangerAndTransfer(String data, Integer fileId) {
        JSONArray jsonArray = new JSONArray(data);
        boolean result = true;
        List<Map<String, Object>> wfList = new ArrayList<>();
        List<Map<String, Object>> tfList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            int count = 0;
            JSONObject object = jsonArray.getJSONObject(i);
            Integer dangerId = object.optInt("dangerId");
            CompanyDanger companyDanger = companyDangerMapper.selectByPrimaryKey(dangerId);
            companyDanger.setTotalNum(String.valueOf(object.opt("totalNum")));
            count += companyDangerMapper.updateByPrimaryKey(companyDanger);

            Map tfMap = new HashMap();
            tfMap.put("name", companyDanger.getName());
            tfMap.put("wf_type", companyDanger.getWf_type());
            tfMap.put("wf_code", companyDanger.getWf_code());
            tfMap.put("totalNum", companyDanger.getTotalNum());
            wfList.add(tfMap);

            Integer transferId = object.optInt("transferId");
            if (companyDanger.getOrderNum() != 0) {
                CompanyTransfer companyTransfer = companyTransferMapper.selectByPrimaryKey(transferId);
                if (object.optString("recentlyNum").length() > 0) {
                    companyTransfer.setRecentlyNum(object.optDouble("recentlyNum"));
                }
                if (object.optString("recentlyDirection").length() > 0) {
                    companyTransfer.setRecentlyDirection(object.optString("recentlyDirection"));
                }
                if (object.optString("recentlyDate").length() > 0) {
                    companyTransfer.setRecentlyDate(object.optString("recentlyDate"));
                }
                if (object.optString("yearNum").length() > 0) {
                    companyTransfer.setYearNum(object.optDouble("yearNum"));
                }
                if (object.optString("repertoryNum").length() > 0) {
                    companyTransfer.setRepertoryNum(object.optDouble("repertoryNum"));
                }
                count += companyTransferMapper.updateByPrimaryKey(companyTransfer);

                Map zfMap = new HashMap();
                zfMap.put("recentlyNum", companyTransfer.getRecentlyNum());
                zfMap.put("recentlyDate", companyTransfer.getRecentlyDate());
                zfMap.put("yearNum", companyTransfer.getYearNum());
                zfMap.put("repertoryNum", companyTransfer.getRepertoryNum());
                zfMap.put("recentlyDirection", companyTransfer.getRecentlyDirection());
                tfList.add(zfMap);
            } else {
                count += 1;
            }
            if (count < 2) {
                result = false;
                break;
            }
        }
        if (result) {
            //开始生成更新版excel
            //获取模板文件copy新文件
            File file = new File(MBFile_PATH);
            String profix = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
            String fileName = new DateTime(new Date()).toString("yyyyMMddHHmmssSSSS");
            if (!excelDir_BY.endsWith(File.separator)) {
                excelDir_BY = excelDir_BY + File.separator;
            }
            String filePath = excelDir_BY + "excel" + File.separator;
            File newFile = new File(filePath + fileName + profix);
            try {
                //获取原一企一档数据
                OneCompanyOneRecordExample example = new OneCompanyOneRecordExample();
                OneCompanyOneRecordExample.Criteria criteria = example.createCriteria();
                criteria.andFileIdEqualTo(fileId);
                List<OneCompanyOneRecord> recordList = oneCompanyOneRecordMapper.selectByExample(example);
                OneCompanyOneRecord record = null;
                if (recordList != null && recordList.size() > 0) {
                    record = recordList.get(0);
                }
                FileUtils.copyFile(file, newFile);
                Map<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("filePath", filePath + fileName + profix);
                paramsMap.put("companyName", record.getCompanyName());
                paramsMap.put("street", record.getStreet());
                paramsMap.put("address", record.getAddress());
                paramsMap.put("representative", record.getRepresentative());
                paramsMap.put("telphone", record.getTelphone());
                paramsMap.put("contacter", record.getContacter());
                paramsMap.put("contactMobile", record.getContactMobile());
                paramsMap.put("industry", record.getIndustry());
                paramsMap.put("area", record.getArea());
                paramsMap.put("code", record.getCode());
                paramsMap.put("zip", record.getZip());
                paramsMap.put("investment", record.getInvestment());
                paramsMap.put("employee", record.getEmployee());
                paramsMap.put("wfList", wfList);
                paramsMap.put("tfList", tfList);
                //获取copy之后的文件，开始更新数据
                if (ExcelUtils.updateExcel(paramsMap)) {
                    String url = webUrl + "/excel/" + fileName + profix;
                    ExcelFile excelFile = excelFileMapper.selectByPrimaryKey(fileId);
                    excelFile.setFileCompanyUrl(url);
                    if (excelFileMapper.updateByPrimaryKey(excelFile) < 1) {
                        result = false;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

}
