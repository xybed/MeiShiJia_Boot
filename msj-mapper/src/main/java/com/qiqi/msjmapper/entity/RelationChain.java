package com.qiqi.msjmapper.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class RelationChain {
    @JSONField(name = "user_id")
    private Integer userId;

    @JSONField(name = "friend_id")
    private Integer friendId;

    private String remark;

    @JSONField(name = "sort_letter")
    private String sortLetter;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSortLetter() {
        return sortLetter;
    }

    public void setSortLetter(String sortLetter) {
        this.sortLetter = sortLetter;
    }
}