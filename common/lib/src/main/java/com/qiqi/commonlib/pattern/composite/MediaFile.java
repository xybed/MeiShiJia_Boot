package com.qiqi.commonlib.pattern.composite;

public class MediaFile extends AbstractComponent{
    private String name;
    private String description;

    public MediaFile(String name, String description) {
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
        return "MediaFile# Name="+name+", Description="+description;
    }
}
