package com.qiqi.commonlib.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Object> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");

        Container container = new ConcreteContainer(list);
        container.add("C");

        Iterator iterator = container.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
