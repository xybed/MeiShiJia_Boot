package com.qiqi.commonlib.pattern.facade;

/**
 * 外观角色
 */
public class JavaDeveloperEquipment {
    //子系统作为整体出现，涉及的类多，导致代码复杂，就要用下面的方法整合起来作为统一入口，但失去灵活性
    public void equipment(){
        new Computer().mac();
        new Net().net();
        new DeveloperTool().tool();
    }
}
