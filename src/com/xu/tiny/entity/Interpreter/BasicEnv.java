package com.xu.tiny.entity.Interpreter;

import java.util.HashMap;

/**
 * 最外部的作用域
 */
public class BasicEnv implements Environment {

    protected HashMap<String,Object>values;

    public BasicEnv(){
        values=new HashMap<>();
    }

    @Override
    public void put(String name, Object value) {
        values.put(name,value);
    }

    @Override
    public Object get(String name) {
        return values.get(name);
    }
}
