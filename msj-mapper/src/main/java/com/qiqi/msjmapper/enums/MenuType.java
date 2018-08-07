package com.qiqi.msjmapper.enums;

public enum MenuType {
    MENU(0, "菜单"),
    BUTTON(1, "按钮");

    private Integer code;

    private String text;

    MenuType(Integer code, String text) {
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
