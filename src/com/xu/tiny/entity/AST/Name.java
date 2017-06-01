package com.xu.tiny.entity.AST;

import com.xu.tiny.entity.Token.Token;

/**
 * Created by xu on 2017/6/1.
 * 叶节点name字段
 */
public class Name extends ASTLeaf {
    public Name(Token t) {
        super(t);
    }

    public String name() {
        return token().getText();
    }
}
