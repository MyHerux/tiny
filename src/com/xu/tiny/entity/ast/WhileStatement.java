package com.xu.tiny.entity.ast;

import java.util.List;

/**
 * Created by xu on 2017/6/1.
 */
public class WhileStatement extends ASTList {

    public WhileStatement(List<ASTree> lis) {
        super(lis);
    }

    public ASTree condition() {
        return child(0);
    }

    public ASTree body() {
        return child(1);
    }

    public String toString() {
        return "(while " + condition() + " " + body() + ")";
    }
}
