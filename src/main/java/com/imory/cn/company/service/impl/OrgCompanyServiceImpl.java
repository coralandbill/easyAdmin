package com.imory.cn.company.service.impl;

import com.imory.cn.company.dao.OrgCompanyMapper;
import com.imory.cn.company.dto.OrgCompany;
import com.imory.cn.company.dto.OrgCompanyExample;
import com.imory.cn.company.service.OrgCompanyService;
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
 * @Date 2017/12/13
 */
@Service
public class OrgCompanyServiceImpl implements OrgCompanyService {

    @Autowired
    private OrgCompanyMapper orgCompanyMapper;

    @Override
    public boolean saveOrgCompany(OrgCompany orgCompany)
    {
        return orgCompanyMapper.insert(orgCompany) > 0;
    }

    @Override
    public boolean updateOrgCompany(OrgCompany orgCompany)
    {
        return orgCompanyMapper.updateByPrimaryKey(orgCompany) > 0;
    }

    @Override
    public List<OrgCompany> listOrgCompany(Map<String, Object> paramsMap)
    {
        int startPos = (int) paramsMap.get("startPos");
        int pageSize = (int) paramsMap.get("pageSize");
        Integer creator = (Integer) paramsMap.get("creator");
        String companyName = (String) paramsMap.get("companyName");
        String street = (String) paramsMap.get("street");

        OrgCompanyExample orgCompanyExample = new OrgCompanyExample();
        OrgCompanyExample.Criteria criteria = orgCompanyExample.createCriteria();
        if (StringUtils.isNotBlank(companyName))
        {
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        if (creator != -1 && StringUtils.isNotBlank(street))
        {
            criteria.andStreetLike("%" + street + "%");
        }
        orgCompanyExample.setOrderByClause("createTime desc" + " limit " + startPos + "," + pageSize);

        return orgCompanyMapper.selectByExample(orgCompanyExample);
    }

    @Override
    public int countOrgCompany(Map<String, Object> paramsMap)
    {
        Integer creator = (Integer) paramsMap.get("creator");
        String companyName = (String) paramsMap.get("companyName");
        String street = (String) paramsMap.get("street");

        OrgCompanyExample orgCompanyExample = new OrgCompanyExample();
        OrgCompanyExample.Criteria criteria = orgCompanyExample.createCriteria();
        if (StringUtils.isNotBlank(companyName))
        {
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        if (creator != -1 && StringUtils.isNotBlank(street))
        {
            criteria.andStreetLike("%" + street + "%");
        }
        return orgCompanyMapper.countByExample(orgCompanyExample);
    }

    @Override
    public OrgCompany selectById(Integer id)
    {
        return orgCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteOrgCompany(String ids)
    {
        String[] idArr = ids.split(",");
        for (String id : idArr)
        {
            OrgCompany orgCompany = orgCompanyMapper.selectByPrimaryKey(Integer.valueOf(id));
            orgCompany.setState(9);
            orgCompanyMapper.updateByPrimaryKey(orgCompany);
        }
        return true;
    }
}