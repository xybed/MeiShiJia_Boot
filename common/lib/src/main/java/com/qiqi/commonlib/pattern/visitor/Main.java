package com.qiqi.commonlib.pattern.visitor;

public class Main {
    public static void main(String[] args){
        ObjectStructure os = new ObjectStructure();
        Element aElement = new AElement();
        Element bElement = new BElement();
        os.add(aElement);
        os.add(bElement);

        Visitor aVisitor = new AVisitor();
        Visitor bVisitor = new BVisitor();

        os.action(aVisitor);
        os.action(bVisitor);
    }
}
