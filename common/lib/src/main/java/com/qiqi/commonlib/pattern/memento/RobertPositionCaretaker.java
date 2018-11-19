package com.qiqi.commonlib.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人
 */
public class RobertPositionCaretaker {
    private List<RobertPositionMemento> mementoList = new ArrayList<>();

    public RobertPositionMemento getMemento(int step) {
        return mementoList.get(step);
    }

    public void setMemento(RobertPositionMemento memento) {
        this.mementoList.add(memento);
    }
}
