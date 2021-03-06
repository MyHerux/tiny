package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.entity.token.Token;
import com.xu.tiny.exception.TinyException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xu on 2017/6/1.
 * 叶节点，没有子节点
 */
public class ASTLeaf extends ASTree {
    private static ArrayList<ASTree> empty = new ArrayList<>();
    private Token token;

    public ASTLeaf(Token t) {
        token = t;
    }

    @Override
    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    public String toString() {
        return token.getText();
    }

    @Override
    public String location() {
        return "第" + token.getLineNumber() + "行";
    }

    @Override
    public Object eval(Environment env) {
        throw  new TinyException("无法执行 eval "+toString(),this);
    }

    Token token() {
        return token;
    }
}
