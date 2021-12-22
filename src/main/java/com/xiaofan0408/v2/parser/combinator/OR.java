package com.xiaofan0408.v2.parser.combinator;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:17
 */
public class OR<T,E> extends AbstractParserCombinator<T,E> {

    private Parser<T,E> p1;

    private Parser<T,E> p2;

    public OR(Parser<T,E> p1, Parser<T,E> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Optional<ParseResult<T>> parse(ParserInput<E> input) {
        Optional<ParseResult<T>> r =  p1.parse(input);
        if (r.isPresent()) {
            return r;
        }
        return p2.parse(input);
    }
}
