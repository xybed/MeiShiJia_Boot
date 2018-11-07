package com.qiqi.commonlib.pattern.composite;

/**
 * 文件夹与文件的树形关系
 */
public abstract class AbstractComponent {
    public abstract void add(AbstractComponent component);
    public abstract AbstractComponent get(int index);
    public abstract String getString();
}
