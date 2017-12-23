package com.imory.cn.company.service;

import com.imory.cn.company.dto.CompanyDanger;
import com.imory.cn.company.dto.OrgCompany;

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
public interface OrgCompanyService {

    boolean saveOrgCompany(OrgCompany orgCompany);

    boolean updateOrgCompany(OrgCompany orgCompany);

    List<OrgCompany> listOrgCompany(Map<String, Object> paramsMap);

    int countOrgCompany(Map<String, Object> paramsMap);

    OrgCompany selectById(Integer id);

    boolean deleteOrgCompany(String ids);

    List<CompanyDanger> listCompanyDanger(Integer fileId);
}
