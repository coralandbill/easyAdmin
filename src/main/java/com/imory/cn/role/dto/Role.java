package com.imory.cn.role.dto;

import java.util.Date;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.name
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private Date create_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.creator
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private Integer creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.description
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_user
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private Integer update_user;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_time
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    private Date update_time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.name
     *
     * @return the value of role.name
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.name
     *
     * @param name the value for role.name
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_time
     *
     * @param create_time the value for role.create_time
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.creator
     *
     * @return the value of role.creator
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.creator
     *
     * @param creator the value for role.creator
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.description
     *
     * @return the value of role.description
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.description
     *
     * @param description the value for role.description
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_user
     *
     * @return the value of role.update_user
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public Integer getUpdate_user() {
        return update_user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_user
     *
     * @param update_user the value for role.update_user
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setUpdate_user(Integer update_user) {
        this.update_user = update_user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_time
     *
     * @return the value of role.update_time
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_time
     *
     * @param update_time the value for role.update_time
     *
     * @mbggenerated Tue Dec 05 13:11:53 CST 2017
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}