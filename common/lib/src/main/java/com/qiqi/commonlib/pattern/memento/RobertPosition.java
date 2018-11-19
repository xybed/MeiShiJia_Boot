package com.qiqi.commonlib.pattern.memento;

/**
 * 原发器
 */
public class RobertPosition {
    private String name;
    private int curXPos;
    private int curYPos;

    public RobertPosition(String name, int curXPos, int curYPos) {
        this.name = name;
        this.curXPos = curXPos;
        this.curYPos = curYPos;
    }

    public void setPos(int curXPos, int curYPos){
        this.curXPos = curXPos;
        this.curYPos = curYPos;
    }

    public void drawScreen() {
        System.out.println("#RobotPosition#"+name+": "+curXPos+", "+curYPos);
    }

    public RobertPositionMemento save(){
        return new RobertPositionMemento(name, curXPos, curYPos);
    }

    public void restore(RobertPositionMemento memento){
        this.name = memento.getName();
        this.curXPos = memento.getCurXPos();
        this.curYPos = memento.getCurYPos();
    }
}
