package com.qiqi.msjmapper.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class ShoppingCart {
    private Integer id;

    @JSONField(name = "user_id")
    private Integer userId;

    @JSONField(name = "product_id")
    private Integer productId;

    private Integer num;

    private Integer status;

    @JSONField(name = "gmt_create")
    private Date gmtCreate;

    @JSONField(name = "gmt_modified")
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}