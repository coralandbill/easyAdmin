package com.imory.cn.company.service.impl;

import com.imory.cn.company.dao.CompanyDangerMapper;
import com.imory.cn.company.dao.CompanyTransferMapper;
import com.imory.cn.company.dao.OrgCompanyMapper;
import com.imory.cn.company.dto.*;
import com.imory.cn.company.service.OrgCompanyService;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
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

        OrgCompanyExample orgCompanyExample = new OrgCompanyExample();
        OrgCompanyExample.Criteria criteria = orgCompanyExample.createCriteria();
        if (StringUtils.isNotBlank(companyName)) {
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        if (StringUtils.isNotBlank(street)) {
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
    public boolean updateDangerAndTransfer(String data) {
        JSONArray jsonArray = new JSONArray(data);
        boolean result = true;
        for (int i = 0; i < jsonArray.length(); i++) {
            int count = 0;
            JSONObject object = jsonArray.getJSONObject(i);
            Integer dangerId = object.optInt("dangerId");
            CompanyDanger companyDanger = companyDangerMapper.selectByPrimaryKey(dangerId);
            companyDanger.setTotalNum(String.valueOf(object.opt("totalNum")));
            count += companyDangerMapper.updateByPrimaryKey(companyDanger);

            Integer transferId = object.optInt("transferId");
            if(companyDanger.getOrderNum() != 0)
            {
                CompanyTransfer companyTransfer = companyTransferMapper.selectByPrimaryKey(transferId);
                if(object.optString("recentlyNum").length() > 0)
                {
                    companyTransfer.setRecentlyNum(object.optDouble("recentlyNum"));
                }
                if(object.optString("recentlyDirection").length() > 0)
                {
                    companyTransfer.setRecentlyDirection(object.optString("recentlyDirection"));
                }
                if(object.optString("recentlyDate").length() > 0)
                {
                    companyTransfer.setRecentlyDate(object.optString("recentlyDate"));
                }
                if(object.optString("yearNum").length() > 0)
                {
                    companyTransfer.setYearNum(object.optDouble("yearNum"));
                }
                if(object.optString("repertoryNum").length() > 0)
                {
                    companyTransfer.setRepertoryNum(object.optDouble("repertoryNum"));
                }
                count += companyTransferMapper.updateByPrimaryKey(companyTransfer);
            }
            else
            {
                count += 1;
            }
            if (count < 2) {
                result = false;
                break;
            }
        }
        return result;
    }
}
