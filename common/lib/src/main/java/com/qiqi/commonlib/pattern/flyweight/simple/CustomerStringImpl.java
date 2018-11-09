package com.qiqi.commonlib.pattern.flyweight.simple;

/**
 * 具体享元角色类
 */
public class CustomerStringImpl implements CustomerString{
    private Character character;

    public CustomerStringImpl(Character character) {
        this.character = character;
    }

    @Override
    public void opt(String state) {
        System.out.println("Inner state="+character);
        System.out.println("Outer state="+state);
    }
}
