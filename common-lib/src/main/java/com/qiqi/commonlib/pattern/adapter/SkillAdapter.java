package com.qiqi.commonlib.pattern.adapter;

public class SkillAdapter extends BaseAdapter{
    private JavaAdaptee javaAdaptee;

    public SkillAdapter(JavaAdaptee javaAdaptee){
        this.javaAdaptee = javaAdaptee;
    }

    @Override
    public void codeAll() {
        javaAdaptee.codeJava();
    }
}
