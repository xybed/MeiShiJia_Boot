package com.qiqi.commonlib.pattern.factory.simple;

public class CodeFactory {
    public static ICode getCodeSkill(String type){
        ICode iCode = null;
        switch (type){
            case "java":
                iCode = new JavaCode();
                break;
            case "php":
                iCode = new PhpCode();
                break;
            case "python":
                iCode = new PythonCode();
                break;
        }
        return iCode;
    }

    public static void main(String[] args){
        ICode code = CodeFactory.getCodeSkill("java");
        code.coding();
        code = CodeFactory.getCodeSkill("php");
        code.coding();
        code = CodeFactory.getCodeSkill("python");
        code.coding();
    }
}
