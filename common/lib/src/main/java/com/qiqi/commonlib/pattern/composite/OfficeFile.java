package com.qiqi.commonlib.pattern.composite;

public class OfficeFile extends AbstractComponent{
    private String name;
    private String description;

    public OfficeFile(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(AbstractComponent component) {
        //unused
    }

    @Override
    public AbstractComponent get(int index) {
        return null;
    }

    @Override
    public String getString() {
        return "OfficeFile# Name="+name+", Description="+description;
    }
}
