package com.qiqi.commonlib.pattern.iterator;

/**
 * 迭代器角色（Iterator）
 */
public interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
    Object currentItem();
}
