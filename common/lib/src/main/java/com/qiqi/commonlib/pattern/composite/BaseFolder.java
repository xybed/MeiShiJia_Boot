package com.qiqi.commonlib.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class BaseFolder extends AbstractComponent{
    private String name;
    private String description;

    private List<AbstractComponent> componentList = new ArrayList<>();

    public BaseFolder(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(AbstractComponent component) {
        componentList.add(component);
    }

    @Override
    public AbstractComponent get(int index) {
        return componentList.get(index);
    }

    @Override
    public String getString() {
        StringBuilder builder = new StringBuilder("*****BaseFolder# enter folder is:"+name+"\n");

        for (AbstractComponent baseFolder : componentList) {
            builder.append(baseFolder.getString()+"\n");
        }

        return builder.toString();
    }
}
