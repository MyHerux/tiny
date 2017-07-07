package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;

import java.util.Iterator;

/**
 * Created by xu on 2017/6/1.
 * 抽象语法树
 */
public abstract class ASTree implements Iterable<ASTree> {
    //返回第i个子节点
    public abstract ASTree child(int i);

    //返回子节点个数
    public abstract int numChildren();

    //返回Iterator对象
    public abstract Iterator<ASTree> children();

    //返回当前节点在程序位置的字符串
    public abstract String location();

    public abstract Object eval(Environment env);

    public Iterator<ASTree> iterator() {
        return children();
    }
}
