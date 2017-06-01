package com.xu.tiny.entity.ast;

import java.util.List;

/**
 * Created by xu on 2017/6/1.
 */
public class IfStatement extends ASTList{

    public IfStatement(List<ASTree> lis) {
        super(lis);
    }

    public ASTree condition() {
        return child(0);
    }

    public ASTree thenBlock() {
        return child(1);
    }

    public ASTree elseBlock() {
        return numChildren() > 2 ? child(2) : null;
    }

    @Override
    public String toString() {
        return "if " + condition() + " " + thenBlock() + " else " + elseBlock() + ")";
    }
}
