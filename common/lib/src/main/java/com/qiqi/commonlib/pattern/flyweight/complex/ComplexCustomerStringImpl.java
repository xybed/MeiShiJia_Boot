package com.qiqi.commonlib.pattern.flyweight.complex;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元对象
 */
public class ComplexCustomerStringImpl implements CustomerString{
    private Map<Character, CustomerString> map = new HashMap<>();

    public void add(Character character, CustomerString customerString){
        map.put(character, customerString);
    }

    @Override
    public void opt(String state) {
        CustomerString temp;
        for(Character character : map.keySet()){
            temp = map.get(character);
            temp.opt(state);
        }
    }
}
