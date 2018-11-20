package com.qiqi.commonlib.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构
 */
public class ObjectStructure {
    private List<Element> elementList = new ArrayList<>();

    public void action(Visitor visitor){
        for(Element element : elementList)
            element.accept(visitor);
    }

    public void add(Element element){
        elementList.add(element);
    }
}
