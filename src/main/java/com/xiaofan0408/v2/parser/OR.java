package com.xiaofan0408.v2.parser;

import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:17
 */
public class OR extends AbstractStringParser {

    private Parser p1;

    private Parser p2;

    public OR(Parser p1, Parser p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Optional<ParseResult<String>> parse(ParserInput input) {
        Optional<ParseResult<String>> r =  p1.parse(input);
        if (r.isPresent()) {
            return r;
        }
        return p2.parse(input);
    }
}
