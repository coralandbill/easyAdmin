package com.imory.cn.excel.service.impl;

import com.imory.cn.company.dao.CompanyDangerMapper;
import com.imory.cn.company.dao.CompanyTransferMapper;
import com.imory.cn.company.dao.OneCompanyOneRecordMapper;
import com.imory.cn.company.dto.CompanyDanger;
import com.imory.cn.company.dto.CompanyTransfer;
import com.imory.cn.company.dto.OneCompanyOneRecordWithBLOBs;
import com.imory.cn.excel.dao.ExcelFileMapper;
import com.imory.cn.excel.dto.ExcelFile;
import com.imory.cn.excel.dto.ExcelFileExample;
import com.imory.cn.excel.service.ExcelFileService;
import com.imory.cn.utils.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private OneCompanyOneRecordMapper oneCompanyOneRecordMapper;

    @Autowired
    private CompanyDangerMapper companyDangerMapper;

    @Autowired
    private CompanyTransferMapper companyTransferMapper;

    @Override
    public List<ExcelFile> listExcelFile(Map<String, Object> paramsMap) {
        int startPos = (int) paramsMap.get("startPos");
        int pageSize = (int) paramsMap.get("pageSize");
        String fileName = (String) paramsMap.get("fileName");
        Integer companyId = (Integer) paramsMap.get("companyId");

        ExcelFileExample excelFileExample = new ExcelFileExample();
        ExcelFileExample.Criteria criteria = excelFileExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        if (StringUtils.isNotBlank(fileName)) {
            criteria.andFileNameLike("%" + fileName + "%");
        }
        excelFileExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);

        return excelFileMapper.selectByExample(excelFileExample);
    }

    @Override
    public int countExcelFile(Map<String, Object> paramsMap) {
        Integer companyId = (Integer) paramsMap.get("companyId");
        String fileName = (String) paramsMap.get("fileName");
        ExcelFileExample excelFileExample = new ExcelFileExample();
        ExcelFileExample.Criteria criteria = excelFileExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        if (StringUtils.isNotBlank(fileName)) {
            criteria.andFileNameLike("%" + fileName + "%");
        }

        return excelFileMapper.countByExample(excelFileExample);
    }

    @Override
    public Integer saveExcelFile(Map<String, Object> paramsMap) {
        ExcelFile excelFile = new ExcelFile();
        excelFile.setCompanyId((Integer) paramsMap.get("companyId"));
        excelFile.setFileName((String) paramsMap.get("fileName"));
        excelFile.setFileName_bk((String) paramsMap.get("fileName_bk"));
        excelFile.setFileDate(DateTime.parse((String) paramsMap.get("fileDate"), DateTimeFormat.forPattern("yyyy-MM-dd")).toDate());
        excelFile.setFileUrl((String) paramsMap.get("fileUrl"));
        excelFile.setFileUrlBak((String) paramsMap.get("fileUrlBak"));
        excelFile.setFilePath((String) paramsMap.get("filePath"));
        excelFile.setCreator((Integer) paramsMap.get("creator"));
        excelFile.setState(0);
        excelFile.setCreateTime(new Date());
        excelFileMapper.insert(excelFile);
        return excelFile.getId() == null ? -1 : excelFile.getId();
    }

    @Override
    public boolean analysisXls(String filePath, Integer companyId, String fileDate, Integer creator, Integer fileId) {
        Map<String, Object> detailMap = ExcelUtils.analysisXls(filePath);
        if (!detailMap.isEmpty()) {
            //开始解析数据
            //1.获取基本数据进行保存
            OneCompanyOneRecordWithBLOBs oneRecord = new OneCompanyOneRecordWithBLOBs();
            oneRecord.setCompanyId(companyId);
            oneRecord.setCompanyName(detailMap.get("companyName") == null ? "" : (String) detailMap.get("companyName"));
            oneRecord.setStreet(detailMap.get("street") == null ? "" : (String) detailMap.get("street"));
            oneRecord.setAddress(detailMap.get("address") == null ? "" : (String) detailMap.get("address"));
            oneRecord.setRepresentative(detailMap.get("representative") == null ? "" : (String) detailMap.get("representative"));
            oneRecord.setTelphone(detailMap.get("telphone") == null ? "" : (String) detailMap.get("telphone"));
            oneRecord.setContacter(detailMap.get("contacter") == null ? "" : (String) detailMap.get("contacter"));
            oneRecord.setContactMobile(detailMap.get("contactMobile") == null ? "" : (String) detailMap.get("contactMobile"));
            oneRecord.setIndustry(detailMap.get("industry") == null ? "" : (String) detailMap.get("industry"));
            oneRecord.setArea(detailMap.get("area") == null ? 0.00 : Double.valueOf((String) detailMap.get("area")));
            oneRecord.setCode(detailMap.get("code") == null ? "" : (String) detailMap.get("code"));
            oneRecord.setZip(detailMap.get("zip") == null ? "" : (String) detailMap.get("zip"));
            oneRecord.setInvestment(detailMap.get("investment") == null ? 0.00 : Double.valueOf((String) detailMap.get("investment")));
            oneRecord.setEmployee(detailMap.get("employee") == null ? 0 : Integer.valueOf((String) detailMap.get("employee")));
            oneRecord.setProblem(detailMap.get("problem") == null ? "" : (String) detailMap.get("problem"));
            oneRecord.setMeasure(detailMap.get("measure") == null ? "" : (String) detailMap.get("measure"));
            oneRecord.setConclusion(detailMap.get("conclusion") == null ? "" : (String) detailMap.get("conclusion"));
            oneRecord.setDocumentDate(DateTime.parse(fileDate, DateTimeFormat.forPattern("yyyy-MM-dd")).toDate());
            oneRecord.setCreateTime(new Date());
            oneRecord.setCreator(creator);
            oneRecord.setFileId(fileId);
            if (oneCompanyOneRecordMapper.insert(oneRecord) > 0) {
                //保存危废列表
                List<Map<String, Object>> wfList = (List) detailMap.get("wfList");
                for (int i = 0; i < wfList.size(); i++) {
                    Map map = wfList.get(i);
                    CompanyDanger companyDanger = new CompanyDanger();
                    companyDanger.setName(map.get("name") == null ? "" : (String) map.get("name"));
                    companyDanger.setWf_type(map.get("wf_type") == null ? "" : (String) map.get("wf_type"));
                    companyDanger.setWf_code(map.get("wf_code") == null ? "" : (String) map.get("wf_code"));
                    companyDanger.setWf_ta(map.get("wf_ta") == null ? "0.00" : (String) map.get("wf_ta"));
                    companyDanger.setDirection(map.get("direction") == null ? "" : (String) map.get("direction"));
                    companyDanger.setOrderNum(map.get("orderNum") == null ? 0 : (int) map.get("orderNum"));
                    companyDanger.setCreateTime(new Date());
                    companyDanger.setCreator(creator);
                    companyDanger.setOneRecordId(oneRecord.getId());
                    companyDanger.setFileId(fileId);
                    companyDangerMapper.insert(companyDanger);

                    if (i != 0) {
                        //保存转移量
                        CompanyTransfer companyTransfer = new CompanyTransfer();
                        companyTransfer.setFileId(fileId);
                        companyTransfer.setCreateTime(new Date());
                        companyTransfer.setOrderNum(map.get("orderNum") == null ? 0 : (int) map.get("orderNum"));
                        companyTransferMapper.insert(companyTransfer);
                    }
                }
                return true;
            }
        }
        return false;
    }

}
