package com.qiqi.commonlib.pattern.flyweight.complex;

import com.qiqi.commonlib.pattern.flyweight.complex.CustomerString;
import com.qiqi.commonlib.pattern.flyweight.complex.CustomerStringImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 享元工厂角色类
 * 一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式
 */
public class CustomerStringFactory {
    private Map<Character, CustomerString> map = new HashMap<>();

    //单纯享元模式
    public CustomerString factory(Character character){
        CustomerString str = map.get(character);
        if(str == null){
            str = new CustomerStringImpl(character);
            map.put(character, str);
        }
        return str;
    }

    //复合享元模式
    public CustomerString factory(List<Character> states) {
        ComplexCustomerStringImpl impl = new ComplexCustomerStringImpl();
        for (Character state : states) {
            impl.add(state, this.factory(state));
        }
        return impl;
    }
}
