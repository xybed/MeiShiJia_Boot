package com.qiqi.msjmapper.pojo;

/**
 * 用于接收下单时携带的请求参数
 * 1.收货地址；2.购物车列表
 */
public class OrderCustom {
    private Integer receivingAddressId;

    private String json;

    public Integer getReceivingAddressId() {
        return receivingAddressId;
    }

    public void setReceivingAddressId(Integer receivingAddressId) {
        this.receivingAddressId = receivingAddressId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
