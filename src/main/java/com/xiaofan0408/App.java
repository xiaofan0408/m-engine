package com.xiaofan0408;

import com.xiaofan0408.v1.Evaluator;
import com.xiaofan0408.v1.ExprAst;
import com.xiaofan0408.v1.Lexer;
import com.xiaofan0408.v1.Parser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Lexer lexer = new Lexer("111+2+3+4*5.1");
        System.out.println(lexer.getTokens());
        Parser parser = new Parser(lexer.getTokens(), lexer.getSource());
        ExprAst exprAst = parser.parseExpression();
        System.out.println(exprAst.toStr());
        Evaluator evaluator = new Evaluator();
        double r = evaluator.eval(exprAst);
        System.out.println(r);
    }
}
