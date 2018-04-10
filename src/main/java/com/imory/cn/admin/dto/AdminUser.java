package com.imory.cn.admin.dto;

import java.util.Date;

public class AdminUser {

    public static final String SESSION_ID = "adminUser";

    public static final String SESSION_AUTH_ID = "authorities";

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.id
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.name
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.psw
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private String psw;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.email
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private String email;

    private String street;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.creator
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private Integer creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.flag
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private Integer flag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.last_login_time
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private Date last_login_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.update_user
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private Integer update_user;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.update_time
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    private Date update_time;

    private Integer roleId;

    private String roleName;

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.id
     *
     * @return the value of admin_user.id
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.id
     *
     * @param id the value for admin_user.id
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.name
     *
     * @return the value of admin_user.name
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.name
     *
     * @param name the value for admin_user.name
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.psw
     *
     * @return the value of admin_user.psw
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public String getPsw() {
        return psw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.psw
     *
     * @param psw the value for admin_user.psw
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setPsw(String psw) {
        this.psw = psw == null ? null : psw.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.email
     *
     * @return the value of admin_user.email
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.email
     *
     * @param email the value for admin_user.email
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.creator
     *
     * @return the value of admin_user.creator
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.creator
     *
     * @param creator the value for admin_user.creator
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.flag
     *
     * @return the value of admin_user.flag
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.flag
     *
     * @param flag the value for admin_user.flag
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.last_login_time
     *
     * @return the value of admin_user.last_login_time
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public Date getLast_login_time() {
        return last_login_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.last_login_time
     *
     * @param last_login_time the value for admin_user.last_login_time
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.update_user
     *
     * @return the value of admin_user.update_user
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public Integer getUpdate_user() {
        return update_user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.update_user
     *
     * @param update_user the value for admin_user.update_user
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setUpdate_user(Integer update_user) {
        this.update_user = update_user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.update_time
     *
     * @return the value of admin_user.update_time
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.update_time
     *
     * @param update_time the value for admin_user.update_time
     *
     * @mbggenerated Tue Dec 05 11:19:05 CST 2017
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}