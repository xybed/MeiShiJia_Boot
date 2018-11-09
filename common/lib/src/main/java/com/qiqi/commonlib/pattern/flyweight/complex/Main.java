package com.qiqi.commonlib.pattern.flyweight.complex;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Character> states = new ArrayList<>();
        states.add('Y');
        states.add('A');
        states.add('N');
        states.add('B');
        states.add('O');

        states.add('Y');
        states.add('B');

        CustomerStringFactory factory = new CustomerStringFactory();
        CustomerString customerString1 = factory.factory(states);

        customerString1.opt("Mutex object test!");
    }
}
