package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.entity.token.Token;

/**
 * Created by xu on 2017/6/1.
 */
public class StringLiteral extends ASTLeaf {

    public StringLiteral(Token t) {
        super(t);
    }

    public String value() {
        return token().getText();
    }

    @Override
    public Object eval(Environment env) {
        return value();
    }
}
