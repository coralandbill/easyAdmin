package com.imory.cn.menu.dao;

import com.imory.cn.menu.dto.Menu;
import com.imory.cn.menu.dto.MenuExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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
public interface MenuCommonMapper {

    /**
     * 查询用户有权限的菜单列表
     *
     * @param userid
     * @return
     */
    @Select({"SELECT id, title as name, title,url, icon, menu_type, display, parent_id FROM menu WHERE id IN(",
            "SELECT menuid FROM role_menu WHERE roleid IN ",
            "(SELECT roleid FROM user_role WHERE userid=#{userid}) OR roleid = -1) AND menu_type<>'2' AND `status`='1'"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_type", property = "menu_type", jdbcType = JdbcType.CHAR),
            @Result(column = "display", property = "display", jdbcType = JdbcType.INTEGER),
            @Result(column = "parent_id", property = "parent_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR)
    })
    List<Menu> listMenuByUserId(int userid);

    /**
     * 查询超级用户的所有权限，超级用户拥有所有权限
     *
     * @return
     */
    @Select({"SELECT url FROM menu"})
    List<String> selectAuthoritiesByRoot();

    /**
     * 查询用户有权限的菜单列表,0是所有用户的默认权限
     *
     * @param userid
     * @return
     */
    @Select({"SELECT url FROM menu WHERE id IN(",
            "SELECT menuid FROM role_menu WHERE roleid IN ",
            "(SELECT roleid FROM user_role WHERE userid=#{userid}) OR roleid=-1) AND `status`='1'"})
    List<String> selectAuthorities(int userid);

    @Select({"CALL delete_menu(#{menuid})"})
    void deleteMenuById(HashMap<String, Object> map);

    @Select({
            "select",
            "id, title, title as name,url, icon, menu_type, display, parent_id, creator, create_time, update_user, ",
            "update_time, status, level",
            "from menu"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
            @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
            @Result(column="menu_type", property="menu_type", jdbcType=JdbcType.CHAR),
            @Result(column="display", property="display", jdbcType=JdbcType.INTEGER),
            @Result(column="parent_id", property="parent_id", jdbcType=JdbcType.INTEGER),
            @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_user", property="update_user", jdbcType=JdbcType.INTEGER),
            @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER)
    })
    List<Menu> selectAll();
}
