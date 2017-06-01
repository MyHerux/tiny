package com.xu.tiny.entity.ast;

import java.util.List;

/**
 * Created by xu on 2017/6/1.
 */
public class NegativeExpr extends ASTList {
    public NegativeExpr(List<ASTree> lis) {
        super(lis);
    }

    public ASTree operand() {
        return child(0);
    }

    @Override
    public String toString() {
        return "-" + operand();
    }
}
