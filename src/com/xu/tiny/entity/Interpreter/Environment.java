package com.xu.tiny.entity.Interpreter;



public interface Environment {
    void put(String name, Object value);

    Object get(String name);
}
