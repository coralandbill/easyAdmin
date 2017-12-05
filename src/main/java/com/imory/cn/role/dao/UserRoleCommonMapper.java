package com.imory.cn.role.dao;

import com.imory.cn.role.dto.Role;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.HashMap;
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
public interface UserRoleCommonMapper {

    @Select({"SELECT r.id, r.name, r.create_time, r.creator, r.description,u.name creatorUser,u1.userid ",
            "FROM role r LEFT JOIN admin_user u ON r.creator=u.id",
            " LEFT JOIN (SELECT roleid,userid FROM user_role WHERE userid=#{userId}) u1 ON r.id=u1.roleid  "})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "creator", property = "creator", jdbcType = JdbcType.INTEGER),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creatorUser", property = "creatorUser", jdbcType = JdbcType.INTEGER)
    })
    List<Role> selectByUserId(int userId);

    @Select({"CALL user_role_update(#{roleids},#{userid},#{creator})"})
    void userRoleUpdate(HashMap<String, Object> map);
}
