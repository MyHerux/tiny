package com.xu.tiny.entity.ast;

import java.util.List;

public class PrimaryExpr extends ASTList {
    public PrimaryExpr(List<ASTree> lis) {
        super(lis);
    }

    public static ASTree create(List<ASTree> lis) {
        return lis.size() == 1 ? lis.get(0) : new PrimaryExpr(lis);
    }
}
