package com.qiqi.msjmapper.enums;

public enum PCategoryLevel {
    ONE(1),
    TWO(2),
    THREE(3);

    private Integer code;

    PCategoryLevel(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
