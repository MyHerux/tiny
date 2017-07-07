package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.entity.token.NumToken;
import com.xu.tiny.entity.token.Token;

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

    @Override
    public Object eval(Environment env) {
        return value();
    }
}
