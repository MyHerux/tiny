package com.xu.tiny.exception;

import com.xu.tiny.entity.ast.ASTree;

/**
 * Created by xu on 2017/7/5.
 */
public class TinyException extends RuntimeException{
    public TinyException(String s) {
        super(s);
    }
    public TinyException(String msg,ASTree t){
        super(msg+" "+t.location());
    }
}
