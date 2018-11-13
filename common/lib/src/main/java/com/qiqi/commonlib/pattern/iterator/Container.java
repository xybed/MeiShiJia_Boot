package com.qiqi.commonlib.pattern.iterator;

/**
 * 容器角色（Container）
 */
public interface Container {
    void add(Object obj);
    void remove(Object obj);
    Iterator createIterator();
}
