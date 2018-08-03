package com.qiqi.msjmapper.enums;

public enum LockedStatus {
    UNLOCKED(0, "未锁住"),
    LOCKED(1, "锁住");

    private Integer code;

    private String text;

    LockedStatus(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
