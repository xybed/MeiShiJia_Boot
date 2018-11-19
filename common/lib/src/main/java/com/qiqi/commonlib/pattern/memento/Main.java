package com.qiqi.commonlib.pattern.memento;

public class Main {
    public static void main(String[] args){
        RobertPositionCaretaker caretaker = new RobertPositionCaretaker();
        RobertPosition position = new RobertPosition("Java", 0, 0);
        position.setPos(0, 1);
        position.drawScreen();
        caretaker.setMemento(position.save());

        position.setPos(1, 1);
        position.drawScreen();
        caretaker.setMemento(position.save());

        position.setPos(5, 5);
        position.drawScreen();
        position.restore(caretaker.getMemento(0));

        position.drawScreen();
    }
}
