package com.qiqi.commonlib.pattern.composite;

public class Main {
    public static void main(String[] args){
        AbstractComponent folder = new BaseFolder("cache", "app cache dir.");
        AbstractComponent mediaFile = new MediaFile("test.png", "test picture.");
        folder.add(mediaFile);
        AbstractComponent childDir = new BaseFolder("word", "office dir.");
        AbstractComponent officeFile = new OfficeFile("rrrr.doc", "office doc file.");
        childDir.add(officeFile);
        folder.add(childDir);
        System.out.println(folder.getString());
    }
}
