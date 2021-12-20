package com.xiaofan0408.v2.parser;

import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:56
 */
public class Zero extends AbstractStringParser {

    @Override
    public Optional<ParseResult<String>> parse(ParserInput input) {
        return CommonUtils.makeResult("",input.rest());
    }
}
