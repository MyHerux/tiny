package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.entity.token.Token;
import com.xu.tiny.exception.TinyException;

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

    @Override
    public Object eval(Environment env) {
        Object value=env.get(name());
        if (value==null){
            throw new TinyException("找不到 "+name()+" 的定义",this);
        }
        else return value;
    }
}
