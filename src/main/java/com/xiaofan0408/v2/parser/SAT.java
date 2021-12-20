package com.xiaofan0408.v2.parser;

import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.parser.preducate.Predicate;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:11
 */
public class SAT extends AbstractStringParser {

    private Predicate pre;

    private Parser parser;

    public SAT(Predicate predicate, Parser parser) {
        this.pre = predicate;
        this.parser = parser;
    }


    @Override
    public Optional<ParseResult<String>> parse(ParserInput input) {
        Optional<ParseResult<String>> r = parser.parse(input);
        if (r.isPresent() && pre.satisfy(r.get().getValue())) {
            r.get().getInput().advance();
            return r;
        }
        return Optional.empty();
    }
}
