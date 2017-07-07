package com.xu.tiny.core;

import com.xu.tiny.entity.Interpreter.BasicEnv;
import com.xu.tiny.entity.ast.ASTree;
import com.xu.tiny.entity.ast.NullStatement;
import com.xu.tiny.entity.token.Token;
import com.xu.tiny.utils.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BasicInterpreter {
    private static String file="./data/interpreter.t";
    public static void main(String[] args) {
        run(new BasicParser(),new BasicEnv());
    }

    private static void run(BasicParser basicParser, BasicEnv basicEnv) {
        try {
            Lexer lex=new Lexer(new FileReader(new File(file)));
            while (lex.peek(0)!= Token.EOF){
                ASTree ast=basicParser.parse(lex);
                if (!(ast instanceof NullStatement)){
                    Object r=ast.eval(basicEnv);
                    Log.d("==>"+r.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
