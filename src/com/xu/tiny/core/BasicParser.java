package com.xu.tiny.core;


import com.xu.tiny.CodeDialog;
import com.xu.tiny.entity.ast.*;
import com.xu.tiny.entity.token.Token;

import java.util.HashSet;

import static com.xu.tiny.core.Parser.rule;


public class BasicParser {

    /*
    primary     : "(" expr ")" | NUMBER|IDENTIFIER|STRING
    factor      : "-" primary | primary
    expr        : factor { OP factor }
    simple      : expr
    statement   : "if" expr block [ "else" block] | while expr block |simple
    program     : [statement] (";"|EOL)
     */

    HashSet<String> reserved = new HashSet<>();
    Parser.Operators operators = new Parser.Operators();
    Parser expr0 = rule();
    Parser primary = rule(PrimaryExpr.class)
            .or(rule().sep("(").ast(expr0).sep(")"),
                    rule().number(NumberLiteral.class),
                    rule().identifier(Name.class, reserved),
                    rule().string(StringLiteral.class));

    Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary), primary);

    protected Parser expr = expr0.expression(BinaryExpr.class, factor, operators);

    Parser statement0 = rule();

    protected Parser block = rule(BlockStatement.class)
            .sep("{").option(statement0)
            .repeat(rule().sep(";", Token.EOL).option(statement0))
            .sep("}");

    Parser simple = rule(PrimaryExpr.class).ast(expr);

    protected Parser statement = statement0.or(
            rule(IfStatement.class).sep("if").ast(expr).ast(block)
                    .option(rule().sep("else").ast(block)),
            rule(WhileStatement.class).sep("fuck").ast(expr).ast(block),
            simple
    );

    Parser program = rule().or(statement, rule(NullStatement.class)).sep(";", Token.EOL);


    public BasicParser() {
        reserved.add(";");
        reserved.add("}");
        reserved.add(Token.EOL);

        operators.add("=", 1, Parser.Operators.RIGHT);
        operators.add("==", 2, Parser.Operators.LEFT);
        operators.add(">", 2, Parser.Operators.LEFT);
        operators.add("<", 2, Parser.Operators.LEFT);
        operators.add("+", 2, Parser.Operators.LEFT);
        operators.add("-", 2, Parser.Operators.LEFT);
        operators.add("*", 2, Parser.Operators.LEFT);
        operators.add("/", 2, Parser.Operators.LEFT);
        operators.add("%", 2, Parser.Operators.LEFT);
    }

    public ASTree parse(Lexer lexer) {
        return program.parse(lexer);
    }

    public static void main(String[] args) {
        Lexer lexer=new Lexer(new CodeDialog());
        BasicParser basicParser=new BasicParser();
        while (lexer.peek(0)!=Token.EOF){
            ASTree asTree=basicParser.parse(lexer);
            System.out.println("=> "+asTree.toString());
        }
    }

}