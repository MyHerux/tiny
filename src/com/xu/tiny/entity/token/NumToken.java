package com.xu.tiny.entity.token;

/**
 * 数字类型
 */
public class NumToken extends Token {
    private int value;
    public NumToken(int lineNo, int val) {
        super(lineNo);
        value=val;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public String getText() {
        return value+"";
    }
    public int getValue(){return value;}
}