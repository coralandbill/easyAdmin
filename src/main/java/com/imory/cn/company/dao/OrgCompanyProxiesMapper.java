package com.imory.cn.company.dao;

import com.imory.cn.company.dto.OrgCompanyProxies;
import com.imory.cn.company.dto.OrgCompanyProxiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrgCompanyProxiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @SelectProvider(type=OrgCompanyProxiesSqlProvider.class, method="countByExample")
    int countByExample(OrgCompanyProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @DeleteProvider(type=OrgCompanyProxiesSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrgCompanyProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @Delete({
        "delete from org_company_proxies",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @Insert({
        "insert into org_company_proxies (orgAccoId, companyId, ",
        "createTime)",
        "values (#{orgAccoId,jdbcType=INTEGER}, #{companyId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OrgCompanyProxies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @InsertProvider(type=OrgCompanyProxiesSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OrgCompanyProxies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @SelectProvider(type=OrgCompanyProxiesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orgAccoId", property="orgAccoId", jdbcType=JdbcType.INTEGER),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrgCompanyProxies> selectByExample(OrgCompanyProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @Select({
        "select",
        "id, orgAccoId, companyId, createTime",
        "from org_company_proxies",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orgAccoId", property="orgAccoId", jdbcType=JdbcType.INTEGER),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrgCompanyProxies selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @UpdateProvider(type=OrgCompanyProxiesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrgCompanyProxies record, @Param("example") OrgCompanyProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @UpdateProvider(type=OrgCompanyProxiesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrgCompanyProxies record, @Param("example") OrgCompanyProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @UpdateProvider(type=OrgCompanyProxiesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrgCompanyProxies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_company_proxies
     *
     * @mbggenerated Wed Dec 13 14:59:39 CST 2017
     */
    @Update({
        "update org_company_proxies",
        "set orgAccoId = #{orgAccoId,jdbcType=INTEGER},",
          "companyId = #{companyId,jdbcType=INTEGER},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrgCompanyProxies record);
}