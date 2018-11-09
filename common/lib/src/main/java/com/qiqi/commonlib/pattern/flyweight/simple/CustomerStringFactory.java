package com.qiqi.commonlib.pattern.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色类
 * 一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式
 */
public class CustomerStringFactory {
    private Map<Character, CustomerString> map = new HashMap<>();

    public CustomerString factory(Character character){
        CustomerString str = map.get(character);
        if(str == null){
            str = new CustomerStringImpl(character);
            map.put(character, str);
        }
        return str;
    }
}
