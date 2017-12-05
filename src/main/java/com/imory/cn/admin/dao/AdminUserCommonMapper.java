package com.imory.cn.admin.dao;

import com.imory.cn.admin.dto.AdminUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/5
 */
public interface AdminUserCommonMapper {

    @Select({
            "select",
            "u.id, u.name, u.email, u.creator, u.flag, u.last_login_time,c.name createUser",
            "from admin_user u LEFT JOIN admin_user c ON u.creator=c.id",
            "where u.name LIKE #{query} LIMIT #{begin},#{pagesize}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "psw", property = "psw", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator", property = "creator", jdbcType = JdbcType.INTEGER),
            @Result(column = "flag", property = "flag", jdbcType = JdbcType.INTEGER),
            @Result(column = "last_login_time", property = "lastLoginTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<AdminUser> select(@Param("begin") int begin, @Param("pagesize") int pageSize, @Param("query") String query);

    /**
     * 登录后更新用户最后登录时间
     * @param user
     * @return
     */
    @Update({"UPDATE admin_user SET last_login_time=CURRENT_TIMESTAMP WHERE name=#{name} AND psw=#{psw}"})
    int updateLoginTime(AdminUser user);
}
