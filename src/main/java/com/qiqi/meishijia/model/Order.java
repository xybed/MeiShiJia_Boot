package com.qiqi.meishijia.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Order {
    @JSONField(name = "order_id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
