package com.qiqi.meishijia.model;

import javax.persistence.*;

@Table(name = "user_token")
public class UserToken {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联user表的username
     */
    private String username;

    /**
     * token，由username加时间戳md5加密生成
     */
    private String token;

    /**
     * 登录的期限，这里存过期的时间戳，以便比较
     */
    private String deadline;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关联user表的username
     *
     * @return username - 关联user表的username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置关联user表的username
     *
     * @param username 关联user表的username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取token，由username加时间戳md5加密生成
     *
     * @return token - token，由username加时间戳md5加密生成
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token，由username加时间戳md5加密生成
     *
     * @param token token，由username加时间戳md5加密生成
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取登录的期限，这里存过期的时间戳，以便比较
     *
     * @return deadline - 登录的期限，这里存过期的时间戳，以便比较
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * 设置登录的期限，这里存过期的时间戳，以便比较
     *
     * @param deadline 登录的期限，这里存过期的时间戳，以便比较
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}