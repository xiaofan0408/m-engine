package com.xiaofan0408;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.parser.*;
import com.xiaofan0408.v2.parser.preducate.IsAlpha;
import com.xiaofan0408.v2.parser.preducate.IsDigit;
import com.xiaofan0408.v2.parser.preducate.IsUnderline;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:52
 */
public class H248Parsec {

    public static AbstractParserCombinator<String> alpha() {
        return new SAT(new IsAlpha(), new Item());
    }

    public static AbstractParserCombinator<String> digit() {
        return new SAT(new IsDigit(), new Item());
    }

    public static AbstractParserCombinator<String> underline() {
        return new SAT(new IsUnderline(), new Item());
    }

    public static AbstractParserCombinator<String> digit_or_alpha_or_underline() {
        return alpha().or(digit().or(underline()));
    }

    public static AbstractParserCombinator<String> zero_or_many(int max, Parser parser){
        return new OR(new OneOrMany(max,parser), new Zero());
    }

    public static AbstractParserCombinator<String> name() {
        return new SEQ(alpha(),
                zero_or_many(64,
                        digit_or_alpha_or_underline()));
    }

}
