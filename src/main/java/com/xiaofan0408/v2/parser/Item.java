package com.xiaofan0408.v2.parser;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:02
 */
public class Item extends AbstractStringParser {
    @Override
    public Optional<ParseResult<String>> parse(ParserInput input) {
        if (!input.empty()) {
            char ch = input.current();
            return CommonUtils.makeResult(Character.toString(ch),input.rest());
        }
        return Optional.empty();
    }
}
