package com.xiaofan0408;

import com.xiaofan0408.v1.Lexer;
import org.junit.Test;

/**
 * @author zefan.xzf
 * @date 2022/1/26 14:16
 */
public class TestLexer {

    @Test
    public void testFn() throws Exception {
        Lexer lexer = new Lexer("111 + sqrt(1)");
        System.out.println(lexer.getTokens());
    }


    @Test
    public void testFn2() throws Exception {
        Lexer lexer = new Lexer("111 + sqrt(1,2)");
        System.out.println(lexer.getTokens());
    }

}
