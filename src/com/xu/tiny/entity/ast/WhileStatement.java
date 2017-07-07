package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.exception.TinyException;

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
        return "(fuck " + condition() + " " + body() + ")";
    }

    @Override
    public Object eval(Environment env) {
        Object result = 0;
        while (checkCondition(env)) {
            result = body().eval(env);
        }
        return result;
    }

    private boolean checkCondition(Environment env) {
        Object conditon=condition().eval(env);
        boolean con;
        if (conditon instanceof Boolean) {
            con = ((Boolean) conditon).booleanValue();
        } else if (conditon instanceof Integer) {
            int intval = ((Integer) conditon).intValue();
            con = intval != 0 ? true : false;//非0为真
        } else {
            throw new TinyException("无法判断if 语句中的条件的正确性 ", this);
        }
        return con;
    }
}
