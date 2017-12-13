package com.imory.cn.company.dao;

import com.imory.cn.company.dto.CompanyDanger;
import com.imory.cn.company.dto.CompanyDangerExample;
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

public interface CompanyDangerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @SelectProvider(type=CompanyDangerSqlProvider.class, method="countByExample")
    int countByExample(CompanyDangerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @DeleteProvider(type=CompanyDangerSqlProvider.class, method="deleteByExample")
    int deleteByExample(CompanyDangerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @Delete({
        "delete from company_danger",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @Insert({
        "insert into company_danger (name, wf_type, ",
        "wf_code, wf_ta, ",
        "direction, createTime, ",
        "creator)",
        "values (#{name,jdbcType=VARCHAR}, #{wf_type,jdbcType=VARCHAR}, ",
        "#{wf_code,jdbcType=VARCHAR}, #{wf_ta,jdbcType=DECIMAL}, ",
        "#{direction,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{creator,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CompanyDanger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @InsertProvider(type=CompanyDangerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CompanyDanger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @SelectProvider(type=CompanyDangerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="wf_type", property="wf_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="wf_code", property="wf_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="wf_ta", property="wf_ta", jdbcType=JdbcType.DECIMAL),
        @Result(column="direction", property="direction", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    List<CompanyDanger> selectByExample(CompanyDangerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @Select({
        "select",
        "id, name, wf_type, wf_code, wf_ta, direction, createTime, creator",
        "from company_danger",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="wf_type", property="wf_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="wf_code", property="wf_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="wf_ta", property="wf_ta", jdbcType=JdbcType.DECIMAL),
        @Result(column="direction", property="direction", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    CompanyDanger selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @UpdateProvider(type=CompanyDangerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CompanyDanger record, @Param("example") CompanyDangerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @UpdateProvider(type=CompanyDangerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CompanyDanger record, @Param("example") CompanyDangerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @UpdateProvider(type=CompanyDangerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CompanyDanger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_danger
     *
     * @mbggenerated Wed Dec 13 14:55:53 CST 2017
     */
    @Update({
        "update company_danger",
        "set name = #{name,jdbcType=VARCHAR},",
          "wf_type = #{wf_type,jdbcType=VARCHAR},",
          "wf_code = #{wf_code,jdbcType=VARCHAR},",
          "wf_ta = #{wf_ta,jdbcType=DECIMAL},",
          "direction = #{direction,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "creator = #{creator,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CompanyDanger record);
}