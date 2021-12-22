package com.xiaofan0408.v2.parser.combinator;

import com.xiaofan0408.v2.base.AbstractParserCombinator;
import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.util.CommonUtils;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:56
 */
public class Zero<T,E> extends AbstractParserCombinator<T,E> {

    @Override
    public Optional<ParseResult<T>> parse(ParserInput<E> input) {
        return CommonUtils.makeResult(null,input.rest());
    }
}
