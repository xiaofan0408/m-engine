package com.xiaofan0408;

import com.xiaofan0408.v1.ExprAst;
import com.xiaofan0408.v1.Token;
import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.parser.combinator.SAT;

/**
 * @author zefan.xzf
 * @date 2021/12/22 16:37
 */
public class CalcParsec {

    private AbstractParserCombinator<ExprAst, Token> number(){
        return new SAT<>(new IsNumber()));
    }

}
