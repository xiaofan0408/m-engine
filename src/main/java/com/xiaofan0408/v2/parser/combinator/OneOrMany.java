package com.xiaofan0408.v2.parser.combinator;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:30
 */
public class OneOrMany<T,E> extends AbstractParserCombinator<T,E> {

    private int max;
    private Parser<T,E> parser;

    public OneOrMany(int max, Parser<T,E> parser) {
        this.max = max;
        this.parser = parser;
    }

    @Override
    public Optional<ParseResult<T>> parse(ParserInput input) {
//        Optional<ParseResult<String>> r = parser.parse(input);
//        if (r.isPresent()) {
//            return parse2(r,1);
//        }
        return Optional.empty();
    }

//    private  Optional<ParseResult<T>> parse2( Optional<ParseResult<T>> pre, int count) {
//        if (count >= max) {
//            return pre;
//        }
//        Optional<ParseResult<String>> r = parser.parse(pre.get().getInput());
//        if (r.isPresent()) {
//            Optional<ParseResult<String>> concat =  CommonUtils.makeResult(pre.get().getValue() + r.get().getValue(),r.get().getInput());
//            return parse2(concat, count + 1);
//        } else {
//            return pre;
//        }
//    }
}
