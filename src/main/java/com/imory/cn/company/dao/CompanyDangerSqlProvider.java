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

import com.imory.cn.company.dto.CompanyDanger;
import com.imory.cn.company.dto.CompanyDangerExample.Criteria;
import com.imory.cn.company.dto.CompanyDangerExample.Criterion;
import com.imory.cn.company.dto.CompanyDangerExample;
import java.util.List;
import java.util.Map;

public class CompanyDangerSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String countByExample(CompanyDangerExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("company_danger");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String deleteByExample(CompanyDangerExample example) {
        BEGIN();
        DELETE_FROM("company_danger");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String insertSelective(CompanyDanger record) {
        BEGIN();
        INSERT_INTO("company_danger");
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_type() != null) {
            VALUES("wf_type", "#{wf_type,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_code() != null) {
            VALUES("wf_code", "#{wf_code,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_ta() != null) {
            VALUES("wf_ta", "#{wf_ta,jdbcType=DECIMAL}");
        }
        
        if (record.getDirection() != null) {
            VALUES("direction", "#{direction,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            VALUES("creator", "#{creator,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String selectByExample(CompanyDangerExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("wf_type");
        SELECT("wf_code");
        SELECT("wf_ta");
        SELECT("direction");
        SELECT("createTime");
        SELECT("creator");
        FROM("company_danger");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        CompanyDanger record = (CompanyDanger) parameter.get("record");
        CompanyDangerExample example = (CompanyDangerExample) parameter.get("example");
        
        BEGIN();
        UPDATE("company_danger");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_type() != null) {
            SET("wf_type = #{record.wf_type,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_code() != null) {
            SET("wf_code = #{record.wf_code,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_ta() != null) {
            SET("wf_ta = #{record.wf_ta,jdbcType=DECIMAL}");
        }
        
        if (record.getDirection() != null) {
            SET("direction = #{record.direction,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{record.creator,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("company_danger");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("wf_type = #{record.wf_type,jdbcType=VARCHAR}");
        SET("wf_code = #{record.wf_code,jdbcType=VARCHAR}");
        SET("wf_ta = #{record.wf_ta,jdbcType=DECIMAL}");
        SET("direction = #{record.direction,jdbcType=VARCHAR}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("creator = #{record.creator,jdbcType=INTEGER}");
        
        CompanyDangerExample example = (CompanyDangerExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    public String updateByPrimaryKeySelective(CompanyDanger record) {
        BEGIN();
        UPDATE("company_danger");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_type() != null) {
            SET("wf_type = #{wf_type,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_code() != null) {
            SET("wf_code = #{wf_code,jdbcType=VARCHAR}");
        }
        
        if (record.getWf_ta() != null) {
            SET("wf_ta = #{wf_ta,jdbcType=DECIMAL}");
        }
        
        if (record.getDirection() != null) {
            SET("direction = #{direction,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{creator,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    protected void applyWhere(CompanyDangerExample example, boolean includeExamplePhrase) {
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