package com.imory.cn.enforce.dao;

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

import com.imory.cn.enforce.dto.Enforce;
import com.imory.cn.enforce.dto.EnforceExample.Criteria;
import com.imory.cn.enforce.dto.EnforceExample.Criterion;
import com.imory.cn.enforce.dto.EnforceExample;
import java.util.List;
import java.util.Map;

public class EnforceSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String countByExample(EnforceExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("enforce");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String deleteByExample(EnforceExample example) {
        BEGIN();
        DELETE_FROM("enforce");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String insertSelective(Enforce record) {
        BEGIN();
        INSERT_INTO("enforce");
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEnforceDate() != null) {
            VALUES("enforceDate", "#{enforceDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpateTime() != null) {
            VALUES("upateTime", "#{upateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            VALUES("creator", "#{creator,jdbcType=INTEGER}");
        }
        
        if (record.getEnforceDesc() != null) {
            VALUES("enforceDesc", "#{enforceDesc,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String selectByExampleWithBLOBs(EnforceExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("enforceDate");
        SELECT("createTime");
        SELECT("upateTime");
        SELECT("creator");
        SELECT("enforceDesc");
        FROM("enforce");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String selectByExample(EnforceExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("enforceDate");
        SELECT("createTime");
        SELECT("upateTime");
        SELECT("creator");
        FROM("enforce");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Enforce record = (Enforce) parameter.get("record");
        EnforceExample example = (EnforceExample) parameter.get("example");
        
        BEGIN();
        UPDATE("enforce");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getEnforceDate() != null) {
            SET("enforceDate = #{record.enforceDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpateTime() != null) {
            SET("upateTime = #{record.upateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{record.creator,jdbcType=INTEGER}");
        }
        
        if (record.getEnforceDesc() != null) {
            SET("enforceDesc = #{record.enforceDesc,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("enforce");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("enforceDate = #{record.enforceDate,jdbcType=TIMESTAMP}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("upateTime = #{record.upateTime,jdbcType=TIMESTAMP}");
        SET("creator = #{record.creator,jdbcType=INTEGER}");
        SET("enforceDesc = #{record.enforceDesc,jdbcType=LONGVARCHAR}");
        
        EnforceExample example = (EnforceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("enforce");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("enforceDate = #{record.enforceDate,jdbcType=TIMESTAMP}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("upateTime = #{record.upateTime,jdbcType=TIMESTAMP}");
        SET("creator = #{record.creator,jdbcType=INTEGER}");
        
        EnforceExample example = (EnforceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    public String updateByPrimaryKeySelective(Enforce record) {
        BEGIN();
        UPDATE("enforce");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEnforceDate() != null) {
            SET("enforceDate = #{enforceDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpateTime() != null) {
            SET("upateTime = #{upateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{creator,jdbcType=INTEGER}");
        }
        
        if (record.getEnforceDesc() != null) {
            SET("enforceDesc = #{enforceDesc,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    protected void applyWhere(EnforceExample example, boolean includeExamplePhrase) {
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