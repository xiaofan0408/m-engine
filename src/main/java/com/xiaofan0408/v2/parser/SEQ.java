package com.xiaofan0408.v2.parser;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:26
 */
public class SEQ extends AbstractStringParser {

    private Parser p1;

    private Parser p2;

    public SEQ(Parser p1, Parser p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Optional<ParseResult<String>> parse(ParserInput input) {
        Optional<ParseResult<String>> r1 = p1.parse(input);
        if (r1.isPresent()) {
            Optional<ParseResult<String>> r2 = p2.parse(input);
            if (r2.isPresent()) {
                return CommonUtils.makeResult(r1.get().getValue() + r2.get().getValue(),input);
            }
        }
        return Optional.empty();
    }
}
