package com.qiqi.msjmapper.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Contacts {
    @JSONField(name = "friend_id")
    private int friendId;

    private String avatar;

    private String remark;//对好友的备注

    @JSONField(name = "sort_letter")
    private String sortLetter;//字母排序

    @JSONField(name = "principal_id")
    private int principalId;

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }
}
