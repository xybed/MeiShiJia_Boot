package com.qiqi.commonlib.pattern.memento;

/**
 * 备忘录
 */
public class RobertPositionMemento {
    private String name;
    private int curXPos;
    private int curYPos;

    public RobertPositionMemento(String name, int curXPos, int curYPos) {
        this.name = name;
        this.curXPos = curXPos;
        this.curYPos = curYPos;
    }

    public String getName() {
        return name;
    }

    public int getCurXPos() {
        return curXPos;
    }

    public int getCurYPos() {
        return curYPos;
    }
}
