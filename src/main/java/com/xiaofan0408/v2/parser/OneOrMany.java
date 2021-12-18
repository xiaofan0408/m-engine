package com.xiaofan0408.v2.parser;

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
public class OneOrMany extends AbstractStringParser {

    private int max;
    private Parser parser;

    public OneOrMany(int max, Parser parser) {
        this.max = max;
        this.parser = parser;
    }

    @Override
    public Optional<ParseResult<String>> parse(ParserInput input) {
        Optional<ParseResult<String>> r = parser.parse(input);
        if (r.isPresent()) {
            return parse2(r,1);
        }
        return Optional.empty();
    }

    private  Optional<ParseResult<String>> parse2( Optional<ParseResult<String>> pre, int count) {
        if (count >= max) {
            return pre;
        }
        Optional<ParseResult<String>> r = parser.parse(pre.get().getInput());
        if (r.isPresent()) {
            Optional<ParseResult<String>> concat =  CommonUtils.makeResult(pre.get().getValue() + r.get().getValue(),r.get().getInput());
            return parse2(concat, count + 1);
        } else {
            return pre;
        }
    }
}
