package com.imory.cn.company.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyDangerExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public CompanyDangerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("fileId is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("fileId is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("fileId =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("fileId <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("fileId >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fileId >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("fileId <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("fileId <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("fileId in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("fileId not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("fileId between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fileId not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andWf_typeIsNull() {
            addCriterion("wf_type is null");
            return (Criteria) this;
        }

        public Criteria andWf_typeIsNotNull() {
            addCriterion("wf_type is not null");
            return (Criteria) this;
        }

        public Criteria andWf_typeEqualTo(String value) {
            addCriterion("wf_type =", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeNotEqualTo(String value) {
            addCriterion("wf_type <>", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeGreaterThan(String value) {
            addCriterion("wf_type >", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeGreaterThanOrEqualTo(String value) {
            addCriterion("wf_type >=", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeLessThan(String value) {
            addCriterion("wf_type <", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeLessThanOrEqualTo(String value) {
            addCriterion("wf_type <=", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeLike(String value) {
            addCriterion("wf_type like", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeNotLike(String value) {
            addCriterion("wf_type not like", value, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeIn(List<String> values) {
            addCriterion("wf_type in", values, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeNotIn(List<String> values) {
            addCriterion("wf_type not in", values, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeBetween(String value1, String value2) {
            addCriterion("wf_type between", value1, value2, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_typeNotBetween(String value1, String value2) {
            addCriterion("wf_type not between", value1, value2, "wf_type");
            return (Criteria) this;
        }

        public Criteria andWf_codeIsNull() {
            addCriterion("wf_code is null");
            return (Criteria) this;
        }

        public Criteria andWf_codeIsNotNull() {
            addCriterion("wf_code is not null");
            return (Criteria) this;
        }

        public Criteria andWf_codeEqualTo(String value) {
            addCriterion("wf_code =", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeNotEqualTo(String value) {
            addCriterion("wf_code <>", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeGreaterThan(String value) {
            addCriterion("wf_code >", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeGreaterThanOrEqualTo(String value) {
            addCriterion("wf_code >=", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeLessThan(String value) {
            addCriterion("wf_code <", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeLessThanOrEqualTo(String value) {
            addCriterion("wf_code <=", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeLike(String value) {
            addCriterion("wf_code like", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeNotLike(String value) {
            addCriterion("wf_code not like", value, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeIn(List<String> values) {
            addCriterion("wf_code in", values, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeNotIn(List<String> values) {
            addCriterion("wf_code not in", values, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeBetween(String value1, String value2) {
            addCriterion("wf_code between", value1, value2, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_codeNotBetween(String value1, String value2) {
            addCriterion("wf_code not between", value1, value2, "wf_code");
            return (Criteria) this;
        }

        public Criteria andWf_taIsNull() {
            addCriterion("wf_ta is null");
            return (Criteria) this;
        }

        public Criteria andWf_taIsNotNull() {
            addCriterion("wf_ta is not null");
            return (Criteria) this;
        }

        public Criteria andWf_taEqualTo(String value) {
            addCriterion("wf_ta =", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taNotEqualTo(String value) {
            addCriterion("wf_ta <>", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taGreaterThan(String value) {
            addCriterion("wf_ta >", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taGreaterThanOrEqualTo(String value) {
            addCriterion("wf_ta >=", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taLessThan(String value) {
            addCriterion("wf_ta <", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taLessThanOrEqualTo(String value) {
            addCriterion("wf_ta <=", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taLike(String value) {
            addCriterion("wf_ta like", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taNotLike(String value) {
            addCriterion("wf_ta not like", value, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taIn(List<String> values) {
            addCriterion("wf_ta in", values, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taNotIn(List<String> values) {
            addCriterion("wf_ta not in", values, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taBetween(String value1, String value2) {
            addCriterion("wf_ta between", value1, value2, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andWf_taNotBetween(String value1, String value2) {
            addCriterion("wf_ta not between", value1, value2, "wf_ta");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("totalNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(String value) {
            addCriterion("totalNum =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(String value) {
            addCriterion("totalNum <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(String value) {
            addCriterion("totalNum >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(String value) {
            addCriterion("totalNum >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(String value) {
            addCriterion("totalNum <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(String value) {
            addCriterion("totalNum <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLike(String value) {
            addCriterion("totalNum like", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotLike(String value) {
            addCriterion("totalNum not like", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<String> values) {
            addCriterion("totalNum in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<String> values) {
            addCriterion("totalNum not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(String value1, String value2) {
            addCriterion("totalNum between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(String value1, String value2) {
            addCriterion("totalNum not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("orderNum =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("orderNum <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("orderNum >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNum >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("orderNum <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("orderNum <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("orderNum in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("orderNum not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("orderNum between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNum not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Integer value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Integer value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Integer value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Integer value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Integer value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Integer> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Integer> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Integer value1, Integer value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Integer value1, Integer value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdIsNull() {
            addCriterion("oneRecordId is null");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdIsNotNull() {
            addCriterion("oneRecordId is not null");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdEqualTo(Integer value) {
            addCriterion("oneRecordId =", value, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdNotEqualTo(Integer value) {
            addCriterion("oneRecordId <>", value, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdGreaterThan(Integer value) {
            addCriterion("oneRecordId >", value, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oneRecordId >=", value, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdLessThan(Integer value) {
            addCriterion("oneRecordId <", value, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("oneRecordId <=", value, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdIn(List<Integer> values) {
            addCriterion("oneRecordId in", values, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdNotIn(List<Integer> values) {
            addCriterion("oneRecordId not in", values, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("oneRecordId between", value1, value2, "oneRecordId");
            return (Criteria) this;
        }

        public Criteria andOneRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oneRecordId not between", value1, value2, "oneRecordId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table company_danger
     *
     * @mbggenerated do_not_delete_during_merge Sat Dec 23 21:50:41 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table company_danger
     *
     * @mbggenerated Sat Dec 23 21:50:41 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}