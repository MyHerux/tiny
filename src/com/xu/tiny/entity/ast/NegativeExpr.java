package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.exception.TinyException;

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

    @Override
    public Object eval(Environment env) {
        Object v=operand().eval(env);
        if (v instanceof Integer){
            return new Integer(-((Integer) v).intValue());
        }
        else
            throw new TinyException("无法对此类型使用-号",this);

    }
}
