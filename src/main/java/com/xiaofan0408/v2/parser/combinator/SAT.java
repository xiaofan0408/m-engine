package com.xiaofan0408.v2.parser.combinator;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.parser.preducate.Predicate;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:11
 */
public class SAT<T,E> extends AbstractParserCombinator<T,E> {

    private Predicate<E> pre;

    public SAT(Predicate<E> predicate) {
        this.pre = predicate;
    }


    @Override
    public Optional<ParseResult<T>> parse(ParserInput<E> input) {
//        Optional<ParseResult<T>> r = parser.parse(input);
//        if (r.isPresent() && pre.satisfy((E)r.get().getInput().current())) {
//            r.get().getInput().advance();
//            return r;
//        }
        if (!input.empty()) {
            E e = input.current();
            if (pre.satisfy(e)) {
                input.advance();

                return CommonUtils.makeResult(e,input.rest());
            }
        }
        return Optional.empty();
    }
}
