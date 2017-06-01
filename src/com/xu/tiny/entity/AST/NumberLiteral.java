package com.xu.tiny.entity.AST;

import com.xu.tiny.entity.Token.NumToken;
import com.xu.tiny.entity.Token.Token;

/**
 * Created by xu on 2017/6/1.
 * 叶节点，整型单词
 */
public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token t) {
        super(t);
    }

    public int value() {
        return ((NumToken) token()).getValue();
    }
}
