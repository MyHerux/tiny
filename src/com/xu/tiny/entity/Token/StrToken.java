package com.xu.tiny.entity.Token;

/**
 * 字符类型
 */
public class StrToken extends Token {
    private String str;
    public StrToken(int lineNo, String str) {
        super(lineNo);
        this.str=str;
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getText() {
        return str;
    }
}
