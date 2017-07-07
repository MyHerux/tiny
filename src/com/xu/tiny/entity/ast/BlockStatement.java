package com.xu.tiny.entity.ast;

import com.xu.tiny.entity.Interpreter.Environment;

import java.util.List;

/**
 * Created by xu on 2017/6/1.
 */
public class BlockStatement extends ASTList{
    public BlockStatement(List<ASTree> lis) {
        super(lis);
    }

    @Override
    public Object eval(Environment env) {
        Object result=0;
        for (ASTree ast:this){
            if (!(ast instanceof NullStatement)){
                result=ast.eval(env);
            }
        }
        return result;
    }
}
