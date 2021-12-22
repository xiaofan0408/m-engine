package com.xiaofan0408;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.Pair;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.parser.*;
import com.xiaofan0408.v2.parser.combinator.*;
import com.xiaofan0408.v2.parser.preducate.IsAlpha;
import com.xiaofan0408.v2.parser.preducate.IsDigit;
import com.xiaofan0408.v2.parser.preducate.IsUnderline;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:52
 */
public class H248Parsec {

    public static AbstractParserCombinator<String,Character> alpha() {
        return new SAT<>(new IsAlpha(), new CharItem());
    }

    public static AbstractParserCombinator<String,Character> digit() {
        return new SAT<>(new IsDigit(), new CharItem());
    }

    public static AbstractParserCombinator<String,Character> underline() {
        return new SAT<>(new IsUnderline(), new CharItem());
    }

    public static AbstractParserCombinator<String,Character> digit_or_alpha_or_underline() {
        return alpha().or(digit().or(underline()));
    }

    public static AbstractParserCombinator<String,Character> zero_or_many(int max, Parser<String,Character> parser){
        return new OR<>(new OneOrMany<>(max,parser), new Zero<>());
    }

    public static AbstractParserCombinator<Pair<String,String>,Character> name() {
        return new SEQ<String,String,Character>(alpha(),
                zero_or_many(64,
                        digit_or_alpha_or_underline()));
    }

}
