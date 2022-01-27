package com.xiaofan0408;

import com.xiaofan0408.v1.Evaluator;
import com.xiaofan0408.v1.ExprAst;
import com.xiaofan0408.v1.Lexer;
import com.xiaofan0408.v1.Parser;
import org.junit.Test;

/**
 * @author zefan.xzf
 * @date 2022/1/26 15:05
 */
public class TestEval {

    @Test
    public void testFn() throws Exception {
        Lexer lexer = new Lexer("111 + sqrt(200)");
        System.out.println(lexer.getTokens());
        Parser parser = new Parser(lexer.getTokens(), lexer.getSource());
        ExprAst exprAst = parser.parseExpression();
        System.out.println(exprAst.toStr());
        Evaluator evaluator = new Evaluator();
        double r = evaluator.eval(exprAst);
        System.out.println(r);
    }

    @Test
    public void testFn2() throws Exception {
        Lexer lexer = new Lexer("111 + 2^20");
        System.out.println(lexer.getTokens());
        Parser parser = new Parser(lexer.getTokens(), lexer.getSource());
        ExprAst exprAst = parser.parseExpression();
        System.out.println(exprAst.toStr());
        Evaluator evaluator = new Evaluator();
        double r = evaluator.eval(exprAst);
        System.out.println(r);
    }

}
