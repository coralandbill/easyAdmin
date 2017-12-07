package com.imory.cn.roleMenu.dao;

import com.imory.cn.menu.dto.Menu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/7
 */
public interface RoleMenuCommonMapper {

    @Select({"SELECT m.id, m.title, m.title as name,m.url, m.icon, m.menu_type, m.display, m.parent_id, m.status,",
            "r.roleid FROM menu m LEFT JOIN (SELECT roleid,menuid FROM role_menu WHERE roleid=#{roleid})",
            " r ON m.id=r.menuid "})
    @Results({
            @Result(column = "parent_id", property = "parent_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "roleid", property = "roleId", jdbcType = JdbcType.INTEGER)
    })
    List<Menu> listMenuByRoleId(int roleId);
}
