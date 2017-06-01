package com.xu.tiny.entity.ast;

import java.util.List;

/**
 * Created by xu on 2017/6/1.
 * 表达式
 */
public class BinaryExpr extends ASTList {
    public BinaryExpr(List<ASTree> lis) {
        super(lis);
    }

    public ASTree left() {
        return child(0);
    }

    public ASTree right() {
        return child(2);
    }

    public String operator() {
        return ((ASTLeaf) child(1)).token().getText();
    }
}
