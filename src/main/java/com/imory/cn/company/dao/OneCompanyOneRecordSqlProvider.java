package com.imory.cn.company.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.imory.cn.company.dto.OneCompanyOneRecordExample.Criteria;
import com.imory.cn.company.dto.OneCompanyOneRecordExample.Criterion;
import com.imory.cn.company.dto.OneCompanyOneRecordExample;
import com.imory.cn.company.dto.OneCompanyOneRecordWithBLOBs;
import java.util.List;
import java.util.Map;

public class OneCompanyOneRecordSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String countByExample(OneCompanyOneRecordExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("onecompany_onerecord");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String deleteByExample(OneCompanyOneRecordExample example) {
        BEGIN();
        DELETE_FROM("onecompany_onerecord");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String insertSelective(OneCompanyOneRecordWithBLOBs record) {
        BEGIN();
        INSERT_INTO("onecompany_onerecord");
        
        if (record.getFileId() != null) {
            VALUES("fileId", "#{fileId,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyId() != null) {
            VALUES("companyId", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyName() != null) {
            VALUES("companyName", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            VALUES("area", "#{area,jdbcType=DOUBLE}");
        }
        
        if (record.getStreet() != null) {
            VALUES("street", "#{street,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentative() != null) {
            VALUES("representative", "#{representative,jdbcType=VARCHAR}");
        }
        
        if (record.getTelphone() != null) {
            VALUES("telphone", "#{telphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter() != null) {
            VALUES("contacter", "#{contacter,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMobile() != null) {
            VALUES("contactMobile", "#{contactMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIndustry() != null) {
            VALUES("industry", "#{industry,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getZip() != null) {
            VALUES("zip", "#{zip,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestment() != null) {
            VALUES("investment", "#{investment,jdbcType=DOUBLE}");
        }
        
        if (record.getEmployee() != null) {
            VALUES("employee", "#{employee,jdbcType=INTEGER}");
        }
        
        if (record.getDocumentDate() != null) {
            VALUES("documentDate", "#{documentDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            VALUES("creator", "#{creator,jdbcType=INTEGER}");
        }
        
        if (record.getProblem() != null) {
            VALUES("problem", "#{problem,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getMeasure() != null) {
            VALUES("measure", "#{measure,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getConclusion() != null) {
            VALUES("conclusion", "#{conclusion,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String selectByExampleWithBLOBs(OneCompanyOneRecordExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("fileId");
        SELECT("companyId");
        SELECT("companyName");
        SELECT("area");
        SELECT("street");
        SELECT("address");
        SELECT("representative");
        SELECT("telphone");
        SELECT("contacter");
        SELECT("contactMobile");
        SELECT("industry");
        SELECT("code");
        SELECT("zip");
        SELECT("investment");
        SELECT("employee");
        SELECT("documentDate");
        SELECT("createTime");
        SELECT("creator");
        SELECT("problem");
        SELECT("measure");
        SELECT("conclusion");
        FROM("onecompany_onerecord");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String selectByExample(OneCompanyOneRecordExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("fileId");
        SELECT("companyId");
        SELECT("companyName");
        SELECT("area");
        SELECT("street");
        SELECT("address");
        SELECT("representative");
        SELECT("telphone");
        SELECT("contacter");
        SELECT("contactMobile");
        SELECT("industry");
        SELECT("code");
        SELECT("zip");
        SELECT("investment");
        SELECT("employee");
        SELECT("documentDate");
        SELECT("createTime");
        SELECT("creator");
        FROM("onecompany_onerecord");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        OneCompanyOneRecordWithBLOBs record = (OneCompanyOneRecordWithBLOBs) parameter.get("record");
        OneCompanyOneRecordExample example = (OneCompanyOneRecordExample) parameter.get("example");
        
        BEGIN();
        UPDATE("onecompany_onerecord");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getFileId() != null) {
            SET("fileId = #{record.fileId,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyName() != null) {
            SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{record.area,jdbcType=DOUBLE}");
        }
        
        if (record.getStreet() != null) {
            SET("street = #{record.street,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentative() != null) {
            SET("representative = #{record.representative,jdbcType=VARCHAR}");
        }
        
        if (record.getTelphone() != null) {
            SET("telphone = #{record.telphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter() != null) {
            SET("contacter = #{record.contacter,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMobile() != null) {
            SET("contactMobile = #{record.contactMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIndustry() != null) {
            SET("industry = #{record.industry,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getZip() != null) {
            SET("zip = #{record.zip,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestment() != null) {
            SET("investment = #{record.investment,jdbcType=DOUBLE}");
        }
        
        if (record.getEmployee() != null) {
            SET("employee = #{record.employee,jdbcType=INTEGER}");
        }
        
        if (record.getDocumentDate() != null) {
            SET("documentDate = #{record.documentDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{record.creator,jdbcType=INTEGER}");
        }
        
        if (record.getProblem() != null) {
            SET("problem = #{record.problem,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getMeasure() != null) {
            SET("measure = #{record.measure,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getConclusion() != null) {
            SET("conclusion = #{record.conclusion,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("onecompany_onerecord");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("fileId = #{record.fileId,jdbcType=INTEGER}");
        SET("companyId = #{record.companyId,jdbcType=INTEGER}");
        SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        SET("area = #{record.area,jdbcType=DOUBLE}");
        SET("street = #{record.street,jdbcType=VARCHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("representative = #{record.representative,jdbcType=VARCHAR}");
        SET("telphone = #{record.telphone,jdbcType=VARCHAR}");
        SET("contacter = #{record.contacter,jdbcType=VARCHAR}");
        SET("contactMobile = #{record.contactMobile,jdbcType=VARCHAR}");
        SET("industry = #{record.industry,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("zip = #{record.zip,jdbcType=VARCHAR}");
        SET("investment = #{record.investment,jdbcType=DOUBLE}");
        SET("employee = #{record.employee,jdbcType=INTEGER}");
        SET("documentDate = #{record.documentDate,jdbcType=DATE}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("creator = #{record.creator,jdbcType=INTEGER}");
        SET("problem = #{record.problem,jdbcType=LONGVARCHAR}");
        SET("measure = #{record.measure,jdbcType=LONGVARCHAR}");
        SET("conclusion = #{record.conclusion,jdbcType=LONGVARCHAR}");
        
        OneCompanyOneRecordExample example = (OneCompanyOneRecordExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("onecompany_onerecord");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("fileId = #{record.fileId,jdbcType=INTEGER}");
        SET("companyId = #{record.companyId,jdbcType=INTEGER}");
        SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        SET("area = #{record.area,jdbcType=DOUBLE}");
        SET("street = #{record.street,jdbcType=VARCHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("representative = #{record.representative,jdbcType=VARCHAR}");
        SET("telphone = #{record.telphone,jdbcType=VARCHAR}");
        SET("contacter = #{record.contacter,jdbcType=VARCHAR}");
        SET("contactMobile = #{record.contactMobile,jdbcType=VARCHAR}");
        SET("industry = #{record.industry,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("zip = #{record.zip,jdbcType=VARCHAR}");
        SET("investment = #{record.investment,jdbcType=DOUBLE}");
        SET("employee = #{record.employee,jdbcType=INTEGER}");
        SET("documentDate = #{record.documentDate,jdbcType=DATE}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("creator = #{record.creator,jdbcType=INTEGER}");
        
        OneCompanyOneRecordExample example = (OneCompanyOneRecordExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    public String updateByPrimaryKeySelective(OneCompanyOneRecordWithBLOBs record) {
        BEGIN();
        UPDATE("onecompany_onerecord");
        
        if (record.getFileId() != null) {
            SET("fileId = #{fileId,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyName() != null) {
            SET("companyName = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{area,jdbcType=DOUBLE}");
        }
        
        if (record.getStreet() != null) {
            SET("street = #{street,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentative() != null) {
            SET("representative = #{representative,jdbcType=VARCHAR}");
        }
        
        if (record.getTelphone() != null) {
            SET("telphone = #{telphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter() != null) {
            SET("contacter = #{contacter,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMobile() != null) {
            SET("contactMobile = #{contactMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIndustry() != null) {
            SET("industry = #{industry,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getZip() != null) {
            SET("zip = #{zip,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestment() != null) {
            SET("investment = #{investment,jdbcType=DOUBLE}");
        }
        
        if (record.getEmployee() != null) {
            SET("employee = #{employee,jdbcType=INTEGER}");
        }
        
        if (record.getDocumentDate() != null) {
            SET("documentDate = #{documentDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{creator,jdbcType=INTEGER}");
        }
        
        if (record.getProblem() != null) {
            SET("problem = #{problem,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getMeasure() != null) {
            SET("measure = #{measure,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getConclusion() != null) {
            SET("conclusion = #{conclusion,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onecompany_onerecord
     *
     * @mbggenerated Sat Dec 23 14:35:53 CST 2017
     */
    protected void applyWhere(OneCompanyOneRecordExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}