package com.xu.tiny.entity.Token;

/**
 * Created by xu on 2017/5/31.
 * 单词
 */
public class Token {
    public static final Token EOF=new Token(-1){};//EOF 表示文件终结
    public static final String EOL="\\n";//EOL 标识一行终结

    private int lineNumber;

    protected Token(int line) {
        this.lineNumber = line;
    }

    public int getLineNumber(){return lineNumber;}

    public boolean isIdentifier(){return false;}//是否是标识符
    public boolean isNumber(){return false;}//是否是数字字面量
    public boolean isString(){return false;}//是否是字符串字面量


    public String getText(){return "";}//具体的字符串
}
