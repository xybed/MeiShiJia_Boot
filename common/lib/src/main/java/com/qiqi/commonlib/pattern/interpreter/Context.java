package com.qiqi.commonlib.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境(Context)角色
 */
public class Context {
    private Map<Variable, Integer> map = new HashMap<>();

    public void addValue(Variable x, int y){
        map.put(x, y);
    }

    public int lookupValue(Variable variable){
        return map.get(variable);
    }
}
