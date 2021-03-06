package com.imory.cn.enforce.dao;

import com.imory.cn.enforce.dto.Enforce;
import com.imory.cn.enforce.dto.EnforceExample;
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

public interface EnforceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @SelectProvider(type=EnforceSqlProvider.class, method="countByExample")
    int countByExample(EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @DeleteProvider(type=EnforceSqlProvider.class, method="deleteByExample")
    int deleteByExample(EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @Delete({
        "delete from enforce",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @Insert({
        "insert into enforce (title, enforceDate, ",
        "createTime, upateTime, ",
        "creator, enforceDesc)",
        "values (#{title,jdbcType=VARCHAR}, #{enforceDate,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{upateTime,jdbcType=TIMESTAMP}, ",
        "#{creator,jdbcType=INTEGER}, #{enforceDesc,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Enforce record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @InsertProvider(type=EnforceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Enforce record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @SelectProvider(type=EnforceSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="enforceDate", property="enforceDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="upateTime", property="upateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER),
        @Result(column="enforceDesc", property="enforceDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Enforce> selectByExampleWithBLOBs(EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @SelectProvider(type=EnforceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="enforceDate", property="enforceDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="upateTime", property="upateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    List<Enforce> selectByExample(EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @Select({
        "select",
        "id, title, enforceDate, createTime, upateTime, creator, enforceDesc",
        "from enforce",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="enforceDate", property="enforceDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="upateTime", property="upateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER),
        @Result(column="enforceDesc", property="enforceDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Enforce selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @UpdateProvider(type=EnforceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Enforce record, @Param("example") EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @UpdateProvider(type=EnforceSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Enforce record, @Param("example") EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @UpdateProvider(type=EnforceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Enforce record, @Param("example") EnforceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @UpdateProvider(type=EnforceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Enforce record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @Update({
        "update enforce",
        "set title = #{title,jdbcType=VARCHAR},",
          "enforceDate = #{enforceDate,jdbcType=TIMESTAMP},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "upateTime = #{upateTime,jdbcType=TIMESTAMP},",
          "creator = #{creator,jdbcType=INTEGER},",
          "enforceDesc = #{enforceDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Enforce record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enforce
     *
     * @mbggenerated Sun Dec 24 12:00:45 CST 2017
     */
    @Update({
        "update enforce",
        "set title = #{title,jdbcType=VARCHAR},",
          "enforceDate = #{enforceDate,jdbcType=TIMESTAMP},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "upateTime = #{upateTime,jdbcType=TIMESTAMP},",
          "creator = #{creator,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Enforce record);
}