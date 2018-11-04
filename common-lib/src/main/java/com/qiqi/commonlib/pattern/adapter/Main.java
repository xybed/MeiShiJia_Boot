package com.qiqi.commonlib.pattern.adapter;

public class Main {
    public static void main(String[] args){
        JavaAdaptee javaAdaptee = new JavaAdaptee();
        Target target = new SkillAdapter(javaAdaptee);
        target.codeAll();
    }
}
