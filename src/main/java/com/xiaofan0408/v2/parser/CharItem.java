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
public class CharItem extends AbstractParserCombinator<String,Character> {

    @Override
    public Optional<ParseResult<String>> parse(ParserInput<Character> input) {
        if (!input.empty()) {
            Character ch = input.current();
            return CommonUtils.makeResult(ch.toString(),input.rest());
        }
        return Optional.empty();
    }
}
