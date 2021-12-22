package com.xiaofan0408.v2.parser.combinator;

import com.xiaofan0408.v2.base.*;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:26
 */
public class SEQ<T,U,E> extends AbstractParserCombinator<Pair<T,U>,E> {

    private Parser<T,E> p1;

    private Parser<U,E> p2;

    public SEQ(Parser<T,E> p1, Parser<U,E> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Optional<ParseResult<Pair<T,U>>> parse(ParserInput<E> input) {
        Optional<ParseResult<T>> r1 = p1.parse(input);
        if (r1.isPresent()) {
            Optional<ParseResult<U>> r2 = p2.parse(input);
            if (r2.isPresent()) {
                return CommonUtils.makeResult(new Pair<>(r1.get().getValue(),r2.get().getValue()),input);
            }
        }
        return Optional.empty();
    }
}
