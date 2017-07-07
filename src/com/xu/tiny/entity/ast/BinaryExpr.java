package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;
import com.xu.tiny.exception.TinyException;

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

    //有两个操作数的表达式
    @Override
    public Object eval(Environment env) {
        String op = operator();
        if (op.equals("=")) {
            //=
            Object right = right().eval(env);
            return computeAssign(env, right);
        } else {
            Object left = left().eval(env);
            Object right = right().eval(env);
            return computeOP(left, right, op);

        }
    }

    //如果两边是数字 直接计算
    private Object computeOP(Object left, Object right, String op) {
        if (left instanceof Integer && right instanceof Integer) {
            return computeNumber((Integer) left, (Integer) right, op);
        } else if (op.equals("+")) {
            return String.valueOf(left) + String.valueOf(right);
        } else if (op.equals("==")) {
            if (left == null) {
                return right == null ? true : false;
            } else {
                return left.equals(right);
            }
        }else {
            throw new TinyException("无法应用 "+op,this);
        }


    }

    private Object computeNumber(Integer left, Integer right, String op) {
        int a=left.intValue();
        int b=right.intValue();
        switch (op){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            case "%":
                return a%b;
            case "==":
                return a==b;
            case ">":
                return a>b;
            case "<":
                return a<b;
            default:
                throw new TinyException("无法识别的符号 "+op,this);
        }
    }

    private Object computeAssign(Environment env, Object rvalue) {
        ASTree left = left();
        if (left instanceof Name) {
            env.put(((Name) left).name(), rvalue);
            return rvalue;
        }
        throw new TinyException("无法在此处应用 = ", this);
    }
}
