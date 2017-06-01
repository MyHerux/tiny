package com.xu.tiny.entity.token;

/**
 * 标示符
 */
public class IdToken extends Token {
    private String text;

    public IdToken(int lineNo, String eol) {
        super(lineNo);
        text = eol;
    }

    @Override
    public boolean isIdentifier() {
        return true;
    }

    @Override
    public String getText() {
        return text;
    }
}
